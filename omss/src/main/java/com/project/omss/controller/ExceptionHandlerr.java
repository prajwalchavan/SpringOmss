package com.project.omss.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.omss.exception.APIException;
import com.project.omss.exception.ErrorMessage;
import com.project.omss.exception.USERException;

@ControllerAdvice
public class ExceptionHandlerr extends Exception {
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";
    
    	// handle global exception
    
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception exception, WebRequest request) {
	/*	ErrorMessage errordetails = new ErrorMessage(new Date(), "Ohh!!! Exception Occured " + exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);*/
		List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorMessage error = new ErrorMessage(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// handle specific exception
	
	@ExceptionHandler(value = APIException.class)
	public ResponseEntity<ErrorMessage> handleAPIException(APIException exception, WebRequest request) {
		 List<String> details = new ArrayList<>();
	        details.add(exception.getLocalizedMessage());
	        ErrorMessage error = new ErrorMessage(BAD_REQUEST, details);
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	// handle specific exception
	
	@ExceptionHandler(value = USERException.class)
	public ResponseEntity<ErrorMessage> handleUserException(USERException exception, WebRequest request) {
		 List<String> details = new ArrayList<>();
	        details.add(exception.getLocalizedMessage());
	        ErrorMessage error = new ErrorMessage(INCORRECT_REQUEST, details);
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
