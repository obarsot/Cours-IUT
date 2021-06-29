package com.sqli.isc.iut.courses.mockito.exception;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 3655303057266638125L;

	public LoginException(String cause) {
		super(cause);
	}
}
