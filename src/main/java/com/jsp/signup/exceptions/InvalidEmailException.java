package com.jsp.signup.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	private String message;
	
	public InvalidEmailException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
