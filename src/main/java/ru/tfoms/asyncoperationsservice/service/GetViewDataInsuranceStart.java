package ru.tfoms.asyncoperationsservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
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
import ru.tfoms.asyncoperationsservice.entity.InsuranceStart;
import ru.tfoms.asyncoperationsservice.entity.MPIError;
import ru.tfoms.asyncoperationsservice.entity.MPIReq;
import ru.tfoms.asyncoperationsservice.repository.InsurancePollRepository;
import ru.tfoms.asyncoperationsservice.repository.InsuranceStartRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIErrorRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIReqRepository;
import ru.tfoms.schemas.generated.GetViewDataInsuranceStartRequest;
import ru.tfoms.schemas.generated.GetViewDataInsuranceStartResponse;
import ru.tfoms.schemas.generated.ResponseErrorData;

@Service
public class GetViewDataInsuranceStart extends AsyncOperationsService {
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final InsuranceStartRepository insuranceStartRepository;
	private final InsurancePollRepository insurancePollRepository;
	private final WebServiceTemplate template;

	public GetViewDataInsuranceStart(MPIReqRepository mpiReqRepository, MPIErrorRepository mpiErrorRepository,
			WebServiceTemplate template, InsuranceStartRepository insuranceStartRepository, InsurancePollRepository insurancePollRepository) {
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.insuranceStartRepository = insuranceStartRepository;
		this.insurancePollRepository = insurancePollRepository;
		this.template = template;
	}

	@Override
//	@Scheduled(cron = "0 0/15 8-23 * * *")
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<InsuranceStart> insuranceStarts = insuranceStartRepository.findByDtreqIsNull();
		insuranceStarts.forEach(t -> {
			String extRid = UUID.randomUUID().toString();
			try {
				GetViewDataInsuranceStartResponse response = template.sendAndReceive(new WebServiceMessageCallback() {

					@Override
					public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
						MarshallingUtils.marshal(template.getMarshaller(), getViewDataInsuranceStartRequest(), message);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = new MPIReq();
						mpiReq.setRid(t.getRid());
						mpiReq.setDt(LocalDateTime.now());
						mpiReq.setReq(out.toByteArray());
						mpiReq.setExtrid(extRid);

						mpiReqRepository.save(mpiReq);
					}

					private GetViewDataInsuranceStartRequest getViewDataInsuranceStartRequest() {
						GetViewDataInsuranceStartRequest request = new GetViewDataInsuranceStartRequest();
						request.setExternalRequestId(extRid);
						request.setTerr(t.getTerr());
						request.setSmo(t.getSmo());
						try {
							request.setDt(DatatypeFactory.newInstance().newXMLGregorianCalendar(t.getDt().toString()));
						} catch (DatatypeConfigurationException e) {
							e.printStackTrace();
						}

						return request;
					}
				}, new WebServiceMessageExtractor<GetViewDataInsuranceStartResponse>() {

					@Override
					public GetViewDataInsuranceStartResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (GetViewDataInsuranceStartResponse) MarshallingUtils
								.unmarshal(template.getUnmarshaller(), message);
					}
				});

				save(t, response, extRid);

			} catch (SoapFaultClientException e) {
				t.setDtreq(LocalDateTime.now());
				t.setHasError(true);

				insuranceStartRepository.save(t);

				MPIError errEntity = new MPIError();
				errEntity.setRid(t.getRid());
				errEntity.setNr(1);
				errEntity.setCode(e.getClass().getSimpleName());
				errEntity.setMessage(e.getFaultStringOrReason());
				errEntity.setDtIns(LocalDateTime.now());
				errEntity.setExtrid(extRid);
				errEntity.setType(SOAP_ERR);

				mpiErrorRepository.save(errEntity);
			}
		});

	}

	private void save(InsuranceStart t, GetViewDataInsuranceStartResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			t.setDtreq(LocalDateTime.now());
			t.setHasError(response.getErrors() != null ? true : false);
			t.setOpToken(response.getOpToken());

			insuranceStartRepository.save(t);
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
				errEntity.setExtrid(extRid);
				errEntity.setType(LOGIC_ERR);

				mpiErrorRepository.save(errEntity);
			}
		} else {
			InsurancePoll insurancePoll = new InsurancePoll();
			insurancePoll.setParentRid(t.getRid());
			insurancePoll.setDtIns(LocalDateTime.now());
			insurancePoll.setOpToken(response.getOpToken());
			
			insurancePollRepository.save(insurancePoll);
		}
		
	}

}
