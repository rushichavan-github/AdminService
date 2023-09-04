package com.onlineGasBooking.admin.exception;

public class AdminAlreadyExistsException extends Exception{
	private String msg;

	public AdminAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public AdminAlreadyExistsException() {
		super();
	}
	
}
