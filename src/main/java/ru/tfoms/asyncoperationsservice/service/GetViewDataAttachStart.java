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
import ru.tfoms.asyncoperationsservice.entity.AttachStart;
import ru.tfoms.asyncoperationsservice.entity.MPIError;
import ru.tfoms.asyncoperationsservice.entity.MPIReq;
import ru.tfoms.asyncoperationsservice.repository.AttachPollRepository;
import ru.tfoms.asyncoperationsservice.repository.AttachStartRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIErrorRepository;
import ru.tfoms.asyncoperationsservice.repository.MPIReqRepository;
import ru.tfoms.schemas.generated.Criteria;
import ru.tfoms.schemas.generated.GetViewDataAttachStartRequest;
import ru.tfoms.schemas.generated.GetViewDataAttachStartResponse;
import ru.tfoms.schemas.generated.ResponseErrorData;

@Service
public class GetViewDataAttachStart implements AsyncOperationsService {
	private final AttachStartRepository attachStartRepository;
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final AttachPollRepository attachPollRepository;
	private final WebServiceTemplate template;

	@Autowired
	public GetViewDataAttachStart(AttachStartRepository attachStartRepository, WebServiceTemplate template, MPIReqRepository mpiReqRepository, MPIErrorRepository mpiErrorRepository, AttachPollRepository attachPollRepository) {
		super();
		this.attachStartRepository = attachStartRepository;
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.attachPollRepository = attachPollRepository;
		this.template = template;
	}

	@Override
//	@Scheduled(cron = "0 0/15 8-23 * * *")
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<AttachStart> attachStarts = attachStartRepository.findByDtreqIsNull();
		Marshaller marshaller = template.getMarshaller();
		Unmarshaller unmarshaller = template.getUnmarshaller();
		attachStarts.forEach(t -> {
			String extRid = UUID.randomUUID().toString();
			try {
				GetViewDataAttachStartResponse response = template
				.sendAndReceive(new WebServiceMessageCallback() {

					@Override
					public void doWithMessage(WebServiceMessage message)
							throws IOException, TransformerException {
						MarshallingUtils.marshal(marshaller, getViewDataAttachStartRequest(t, extRid), message);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = new MPIReq();
						mpiReq.setRid(t.getRid());
						mpiReq.setDt(LocalDateTime.now());
						mpiReq.setReq(out.toByteArray());
						mpiReq.setExtrid(extRid);

						mpiReqRepository.save(mpiReq);
					}
				}, new WebServiceMessageExtractor<GetViewDataAttachStartResponse>() {

					@Override
					public GetViewDataAttachStartResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (GetViewDataAttachStartResponse) MarshallingUtils.unmarshal(unmarshaller,
								message);
					}
				});
		
				save(t, response, extRid);
				
			} catch (SoapFaultClientException e) {
				t.setDtreq(LocalDateTime.now());
				t.setHasError(true);

				attachStartRepository.save(t);
				
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
	
	private void save(AttachStart t, GetViewDataAttachStartResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			t.setDtreq(LocalDateTime.now());
			t.setHasError(response.getErrors() != null ? true : false);
			t.setOpToken(response.getOpToken());

			attachStartRepository.save(t);
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
			AttachPoll attachPoll = new AttachPoll();
			attachPoll.setParentRid(t.getRid());
			attachPoll.setDtIns(LocalDateTime.now());
			attachPoll.setOpToken(response.getOpToken());
			
			attachPollRepository.save(attachPoll);
		}
	}

	private GetViewDataAttachStartRequest getViewDataAttachStartRequest(AttachStart attachStart, String extRid) {
		GetViewDataAttachStartRequest request = new GetViewDataAttachStartRequest();
		request.setExternalRequestId(extRid);
		try {
			request.setDt(DatatypeFactory.newInstance().newXMLGregorianCalendar(attachStart.getDt().toString()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	 	Collection<Criteria> list = request.getCriteria();
	 	Collection<ru.tfoms.asyncoperationsservice.entity.Criteria> criterias = attachStart.getCriterias();
	 	criterias.forEach(c->{
	 		Criteria criteria = new Criteria();
	 		criteria.setFieldNameAttached(c.getFieldName());
	 		criteria.setLogicOperation(c.getOperation());
	 		criteria.setValue(c.getValue());
	 		list.add(criteria);
	 	});
		
		return request;
	}

}
