package com.dakr.customexception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String errorCode;
	public String ErrorMessege;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessege() {
		return ErrorMessege;
	}

	public void setErrorMessege(String errorMessege) {
		ErrorMessege = errorMessege;
	}

	public ControllerException(String errorCode, String errorMessege) {
		super();
		this.errorCode = errorCode;
		ErrorMessege = errorMessege;
	}

	@Override
	public String toString() {
		return "ControllerException [errorCode=" + errorCode + ", ErrorMessege=" + ErrorMessege + "]";
	}

	public ControllerException() {

	}

}
