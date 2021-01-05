package com.project.omss.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.omss.exception.APIException;
import com.project.omss.exception.ErrorDetails;
import com.project.omss.exception.ErrorMessage;
import com.project.omss.exception.USERException;

/**
 * Exception handler class for all controller classes.
 * 
 * @author Prajwal
 *
 */
@ControllerAdvice
public class ExceptionHandlerr extends Exception {
	private static final String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	private static final String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception exception, WebRequest request) {

		final List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorMessage error = new ErrorMessage(INCORRECT_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = APIException.class)
	public ResponseEntity<ErrorMessage> handleAPIException(APIException exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorMessage error = new ErrorMessage(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = USERException.class)
	public ResponseEntity<ErrorMessage> handleUserException(USERException exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorMessage error = new ErrorMessage(INCORRECT_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationExceptionHandling(MethodArgumentNotValidException exception) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error",
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
