package com.onlineGasBooking.admin.exception;

public class InvalidCredentialsException extends Exception{
	private String msg;

	public InvalidCredentialsException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidCredentialsException() {
		super();
	}
	
}
