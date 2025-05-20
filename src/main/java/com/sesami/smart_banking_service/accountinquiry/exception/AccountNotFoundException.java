package com.sesami.smart_banking_service.accountinquiry.exception;

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super();
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
	}

	 public AccountNotFoundException(String message) {
	        super(message);
	    }
}
