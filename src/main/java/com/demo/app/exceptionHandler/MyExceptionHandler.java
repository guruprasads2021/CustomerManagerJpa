package com.demo.app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e) {
		return new ResponseEntity<Object>("Invalid input, expecting a numeric as input", HttpStatus.BAD_REQUEST);
	}
	
}
