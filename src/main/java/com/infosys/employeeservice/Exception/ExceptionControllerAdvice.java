package com.infosys.employeeservice.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.employeeservice.model.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	private Environment environment;
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(EmployeeAlreadyExistsException ex){
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(environment.getProperty(ex.getMessage()));
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(NoSuchEmployeeException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchEmployeeException ex){
	ErrorMessage error=new ErrorMessage();
	error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	error.setMessage(environment.getProperty(ex.getMessage()));
	return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
}
