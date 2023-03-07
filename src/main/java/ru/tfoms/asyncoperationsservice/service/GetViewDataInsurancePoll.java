package ru.tfoms.asyncoperationsservice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;

import javax.xml.transform.TransformerException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.support.MarshallingUtils;

import ru.tfoms.asyncoperationsservice.entity.InsurancePoll;
import ru.tfoms.asyncoperationsservice.entity.MPIError;
import ru.tfoms.asyncoperationsservice.entity.MPIReq;
import ru.tfoms.asyncoperationsservice.repository.InsurancePollRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIErrorRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIReqRepository;
import ru.tfoms.asyncoperationsservice.service.AsyncOperationsService.Status;
import ru.tfoms.schemas.generated.GetViewDataInsurancePollRequest;
import ru.tfoms.schemas.generated.GetViewDataInsurancePollResponse;
import ru.tfoms.schemas.generated.ResponseErrorData;

@Service
public class GetViewDataInsurancePoll extends AsyncOperationsService {
	private final InsurancePollRepository insurancePollRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final MPIReqRepository mpiReqRepository;
//	private final InsuranceContentRepository contentRepository;
	private final WebServiceTemplate template;
	
	public GetViewDataInsurancePoll(InsurancePollRepository insurancePollRepository, MPIReqRepository mpiReqRepository, MPIErrorRepository mpiErrorRepository, WebServiceTemplate template) {
		this.insurancePollRepository = insurancePollRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.mpiReqRepository = mpiReqRepository;
		this.template = template;
	}
	
	@Override
//	@Scheduled(cron = "0 0/15 8-23 * * *")
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<InsurancePoll> requests = insurancePollRepository.findByStatusIsNullOrStatusNotIn(ignoredStatuses);
		requests.forEach(t -> {
			GetViewDataInsurancePollRequest request = getViewDataInsurancePollRequest(t);
			try {
				GetViewDataInsurancePollResponse response = (GetViewDataInsurancePollResponse) template
						.sendAndReceive(new WebServiceMessageCallback() {

							@Override
							public void doWithMessage(WebServiceMessage message)
									throws IOException, TransformerException {
								MarshallingUtils.marshal(template.getMarshaller(), request, message);

								ByteArrayOutputStream out = new ByteArrayOutputStream();
								message.writeTo(out);
								MPIReq mpiReq = new MPIReq();
								mpiReq.setRid(t.getRid());
								mpiReq.setDt(LocalDateTime.now());
								mpiReq.setReq(out.toByteArray());
								mpiReq.setExtrid(request.getExternalRequestId());

								mpiReqRepository.save(mpiReq);
							}
						}, new WebServiceMessageExtractor<GetViewDataInsurancePollResponse>() {

							@Override
							public GetViewDataInsurancePollResponse extractData(WebServiceMessage message)
									throws IOException, TransformerException {
								ByteArrayOutputStream out = new ByteArrayOutputStream();
								message.writeTo(out);
								MPIReq mpiReq = mpiReqRepository.getByExtrid(request.getExternalRequestId());
								mpiReq.setResp(out.toByteArray());

								mpiReqRepository.save(mpiReq);

								return (GetViewDataInsurancePollResponse) MarshallingUtils.unmarshal(template.getUnmarshaller(),
										message);
							}
						});

				save(t, response);

			} catch (SoapFaultClientException e) {
				t.setDtreq(LocalDateTime.now());
				t.setHasError(true);

				insurancePollRepository.save(t);

				MPIError errEntity = new MPIError();
				errEntity.setRid(t.getRid());
				errEntity.setNr(1);
				errEntity.setCode(e.getClass().getSimpleName());
				errEntity.setMessage(e.getFaultStringOrReason());
				errEntity.setDtIns(LocalDateTime.now());
				errEntity.setExtrid(request.getExternalRequestId());
				errEntity.setType(SOAP_ERR);

				mpiErrorRepository.save(errEntity);
			}
		});
	}

	private void save(InsurancePoll t, GetViewDataInsurancePollResponse response) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			t.setDtreq(LocalDateTime.now());
			t.setHasError(response.getErrors() != null ? true : false);
			t.setStatus(response.getProcessingStatus());
			t.setExtrid(response.getExternalRequestId());

			insurancePollRepository.save(t);
		}
		
		if (response.getErrors() != null) {
			Collection<ResponseErrorData> errors = response.getErrors().getErrorItem();
			int nr = 0;
			for (ResponseErrorData err : errors) {
				if (err.getCode().trim().equals(INTERNAL_SERVICE_ERROR))
					continue; // do nothing
				MPIError errEntity = new MPIError();
				errEntity.setRid(t.getRid());
				errEntity.setNr(++nr);
				errEntity.setCode(err.getCode());
				errEntity.setMessage(err.getMessage());
				errEntity.setTag(err.getTag());
				errEntity.setValue(err.getValue());
				errEntity.setDtIns(LocalDateTime.now());
				errEntity.setExtrid(response.getExternalRequestId());
				errEntity.setType(LOGIC_ERR);

				mpiErrorRepository.save(errEntity);
			}
		} else if (Status.valueOf(response.getProcessingStatus().trim().toUpperCase()) == Status.COMPLETED) {
			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				response.getContent().writeTo(os);
				saveContent(os.toByteArray(), t.getRid());
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void saveContent(byte[] byteArray, Long rid) throws IOException {
		ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(byteArray));
		zis.getNextEntry();
		Scanner sc = new Scanner(zis);
		int nr = 0;
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
		zis.closeEntry();
		zis.close();
	}

	private GetViewDataInsurancePollRequest getViewDataInsurancePollRequest(InsurancePoll t) {
		GetViewDataInsurancePollRequest request = new GetViewDataInsurancePollRequest();
		request.setExternalRequestId(UUID.randomUUID().toString());
		request.setOpToken(t.getOpToken());
		
		return request;
	}

}
