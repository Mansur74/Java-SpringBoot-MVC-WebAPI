package com.enoca.work.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorObject> handleCompanyNotFoundExcepiton(CompanyNotFoundException ex, WebRequest request)
	{
		ErrorObject errorObject = new ErrorObject();
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorObject> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request)
	{
		ErrorObject errorObject = new ErrorObject();
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
		
	}
}
