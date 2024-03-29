package com.jsp.signup.exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {
	private String message;


	public InvalidPasswordException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}



}
