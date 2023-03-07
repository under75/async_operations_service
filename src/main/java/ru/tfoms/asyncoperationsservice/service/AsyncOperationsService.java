package ru.tfoms.asyncoperationsservice.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;


public abstract class AsyncOperationsService {
	public final static Integer SOAP_ERR = 1;
	public final static Integer LOGIC_ERR = 2;
	public final static String INTERNAL_SERVICE_ERROR = "500";
	public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public enum Status {
		ERROR, COMPLETED, NEW, PROCESSING
	}

	public static Collection<String> ignoredStatuses = new ArrayList<>();
	static {
		ignoredStatuses.add(Status.COMPLETED.name());
		ignoredStatuses.add(Status.ERROR.name());
	}
	
	abstract void process();
}
