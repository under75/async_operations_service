package ru.tfoms.asyncoperationsservice.service;

public interface AsyncOperationsService {
	public final static Integer SOAP_ERR = 1;
	public final static Integer LOGIC_ERR = 2;
	public final static String INTERNAL_SERVICE_ERROR = "500";
	
	void process();
}
