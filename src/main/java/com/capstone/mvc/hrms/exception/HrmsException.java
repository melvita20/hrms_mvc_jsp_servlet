package com.capstone.mvc.hrms.exception;

public class HrmsException extends Exception{

	private String errorCode;
	private int errorCodeNumber;

	
	public String getErrorCode() {
		return errorCode;
	}


	public HrmsException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public HrmsException(String message, Throwable cause, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public HrmsException(String message, Throwable cause) {
		super(message);
	}
	
	
	public HrmsException(String message,  String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public HrmsException(Throwable cause,  String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public HrmsException(String message,  int errorCode) {
		super(message);
		this.errorCodeNumber = errorCode;
	}
}
