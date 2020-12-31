package com.wipro.test.getdataservice.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionResponse extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionResponse.class);

	@ExceptionHandler(EmployeeNotFondException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFondException ex, WebRequest request)
			throws Exception {

		ExceptionEntity exceptionEntity = new ExceptionEntity(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionEntity, HttpStatus.NOT_FOUND);

	}
}
