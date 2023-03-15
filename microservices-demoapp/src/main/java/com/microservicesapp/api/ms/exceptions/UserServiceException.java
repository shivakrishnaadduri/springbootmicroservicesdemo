package com.microservicesapp.api.ms.exceptions;

public class UserServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -3297163960170700219L;

	public UserServiceException(String message) {
		super(message);
	}

}
