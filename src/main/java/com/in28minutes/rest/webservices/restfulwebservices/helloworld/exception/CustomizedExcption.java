package com.in28minutes.rest.webservices.restfulwebservices.helloworld.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@RestControllerAdvice

public class CustomizedExcption extends ResponseEntityExceptionHandler{

	public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest wr)	{
		
		 ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), e.getMessage(), wr.getDescription(false));
		 
		 return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e, WebRequest wr)	{
		
		 ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), e.getMessage(), wr.getDescription(false));
		 
		 return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		 ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
