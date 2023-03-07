package ru.tfoms.asyncoperationsservice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.support.MarshallingUtils;

import ru.tfoms.asyncoperationsservice.entity.AttachPoll;
import ru.tfoms.asyncoperationsservice.entity.Content;
import ru.tfoms.asyncoperationsservice.entity.MPIError;
import ru.tfoms.asyncoperationsservice.entity.MPIReq;
import ru.tfoms.asyncoperationsservice.repository.AttachPollRepository;
import ru.tfoms.asyncoperationsservice.repository.ContentRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIErrorRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIReqRepository;
import ru.tfoms.schemas.generated.GetViewDataAttachPollRequest;
import ru.tfoms.schemas.generated.GetViewDataAttachPollResponse;
import ru.tfoms.schemas.generated.ResponseErrorData;

@Service
public class GetViewDataAttachPoll implements AsyncOperationsService {
	private final AttachPollRepository attachPollRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final MPIReqRepository mpiReqRepository;
	private final ContentRepository contentRepository;
	private final WebServiceTemplate template;
	public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public enum Status {
		ERROR, COMPLETED, NEW, PROCESSING
	}

	public static Collection<String> ignoredStatuses = new ArrayList<>();
	static {
		ignoredStatuses.add(Status.COMPLETED.name());
		ignoredStatuses.add(Status.ERROR.name());
	}

	@Autowired
	public GetViewDataAttachPoll(AttachPollRepository attachPollRepository, WebServiceTemplate template,
			MPIErrorRepository mpiErrorRepository, MPIReqRepository mpiReqRepository,
			ContentRepository contentRepository) {
		this.attachPollRepository = attachPollRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.mpiReqRepository = mpiReqRepository;
		this.contentRepository = contentRepository;
		this.template = template;
	}

	@Override
//	@Scheduled(cron = "0 0/15 8-23 * * *")
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<AttachPoll> requests = attachPollRepository.findByStatusIsNullOrStatusNotIn(ignoredStatuses);
		Marshaller marshaller = template.getMarshaller();
		Unmarshaller unmarshaller = template.getUnmarshaller();
		requests.forEach(t -> {
			GetViewDataAttachPollRequest request = getViewDataAttachPollRequest(t);
			try {
				GetViewDataAttachPollResponse response = (GetViewDataAttachPollResponse) template
						.sendAndReceive(new WebServiceMessageCallback() {

							@Override
							public void doWithMessage(WebServiceMessage message)
									throws IOException, TransformerException {
								MarshallingUtils.marshal(marshaller, request, message);

								ByteArrayOutputStream out = new ByteArrayOutputStream();
								message.writeTo(out);
								MPIReq mpiReq = new MPIReq();
								mpiReq.setRid(t.getRid());
								mpiReq.setDt(LocalDateTime.now());
								mpiReq.setReq(out.toByteArray());
								mpiReq.setExtrid(request.getExternalRequestId());

								mpiReqRepository.save(mpiReq);
							}
						}, new WebServiceMessageExtractor<GetViewDataAttachPollResponse>() {

							@Override
							public GetViewDataAttachPollResponse extractData(WebServiceMessage message)
									throws IOException, TransformerException {
								ByteArrayOutputStream out = new ByteArrayOutputStream();
								message.writeTo(out);
								MPIReq mpiReq = mpiReqRepository.getByExtrid(request.getExternalRequestId());
								mpiReq.setResp(out.toByteArray());

								mpiReqRepository.save(mpiReq);

								return (GetViewDataAttachPollResponse) MarshallingUtils.unmarshal(unmarshaller,
										message);
							}
						});

				save(t, response);

			} catch (SoapFaultClientException e) {
				t.setDtreq(LocalDateTime.now());
				t.setHasError(true);

				attachPollRepository.save(t);

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

	private void save(AttachPoll t, GetViewDataAttachPollResponse response) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			t.setDtreq(LocalDateTime.now());
			t.setHasError(response.getErrors() != null ? true : false);
			t.setStatus(response.getProcessingStatus());
			t.setExtrid(response.getExternalRequestId());

			attachPollRepository.save(t);
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

	private GetViewDataAttachPollRequest getViewDataAttachPollRequest(AttachPoll t) {
		GetViewDataAttachPollRequest request = new GetViewDataAttachPollRequest();
		request.setExternalRequestId(UUID.randomUUID().toString());
		request.setOpToken(t.getOpToken());

		return request;
	}

	private void saveContent(byte[] data, Long rid) throws IOException {
		ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(data));
		zis.getNextEntry();
		Scanner sc = new Scanner(zis);
		int nr = 0;
		while (sc.hasNextLine()) {
			String[] record = sc.nextLine().split(",");
			Content content = new Content();
			content.setRid(rid);
			content.setNr(++nr);
			content.setDt(YearMonth.parse(record[0], DateTimeFormatter.ofPattern("MM.yyyy")).atDay(1));
			content.setPersonEnp(record[1]);
			content.setSmoId(record[2]);
			content.setSmoName(record[3]);
			content.setSmoOkatoId(record[4]);
			content.setPersonGender(record[5].isEmpty() ? null : Integer.valueOf(record[5]));
			content.setPersonAge(record[6]);
			content.setMoCode(record[7]);
			content.setMoId(record[8]);
			content.setMoName(record[9]);
			content.setMoOkato(record[10]);
			content.setFmoId(record[11]);
			content.setAttachType(record[12].isEmpty() ? null : Integer.valueOf(record[12]));// убрать не нулл
			content.setAttachDepartType(record[13].isEmpty() ? null : Integer.valueOf(record[13]));
			content.setAttachMethod(record[14].isEmpty() ? null : Integer.valueOf(record[14]));
			content.setAttachEffDate(record[15].isEmpty() ? null : LocalDate.parse(record[15], DATE_TIME_FORMATTER));
			content.setAttachExpDate(record[16].isEmpty() ? null : LocalDate.parse(record[16], DATE_TIME_FORMATTER));
			content.setDoctorId(record[17]);
			content.setDoctorSnils(record[18]);
			content.setDoctorEffDate(record[19].isEmpty() ? null : LocalDate.parse(record[19], DATE_TIME_FORMATTER));
			content.setAttachStatus(record[20]);
			contentRepository.save(content);
		}
		sc.close();
		zis.closeEntry();
		zis.close();
	}
}
