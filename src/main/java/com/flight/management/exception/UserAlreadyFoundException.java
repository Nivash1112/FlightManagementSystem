package com.flight.management.exception;

public class UserAlreadyFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyFoundException(String msg) {
		super(msg);
	}
}
