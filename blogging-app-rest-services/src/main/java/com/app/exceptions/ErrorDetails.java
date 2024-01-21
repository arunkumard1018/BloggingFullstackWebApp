package com.app.exceptions;

import java.time.LocalDateTime;

/**
 * Custom Error Details for the Application
 * 
 * Note : By default Spring uses ResponseEntityExceptionHandler class for Error structure
 * this is standard class which handles all spring mvc raised exceptions and it returns formated error details
 * 
 * 
 * 
 * 
 * */


public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	

}
