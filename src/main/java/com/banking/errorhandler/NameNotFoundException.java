package com.banking.errorhandler;

public class NameNotFoundException extends Exception {

	public NameNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public NameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NameNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NameNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public void printError(String msg) {
		System.out.printf("Error: %s", msg);
	}

}
