package com.onlineGasBooking.admin.exception;

public class AdminDoesNotExistException extends Exception{
	private String msg;

	public AdminDoesNotExistException(String msg) {
		super();
		this.msg = msg;
	}

	public AdminDoesNotExistException() {
		super();
	}
	
}
