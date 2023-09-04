package com.onlineGasBooking.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=AdminAlreadyExistsException.class)
	public ResponseEntity<String> adminAlreadyExistsException(AdminAlreadyExistsException user){
		return new ResponseEntity<>("Admin already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=AdminDoesNotExistException.class)
	public ResponseEntity<String> adminDoesNotExistsException(AdminDoesNotExistException user){
		return new ResponseEntity<>("Admin does not exist in database.Please try again",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=InvalidCredentialsException.class)
	public ResponseEntity<String> Exception(InvalidCredentialsException user){
		return new ResponseEntity<>("Invalid login credentials.Please try again",HttpStatus.CONFLICT);
	}
}
