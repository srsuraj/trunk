package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// add exception handling code here
	
	// Add an exceptional handler using @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
			
			StudentErrorResponse res = new StudentErrorResponse();
			res.setStatus(HttpStatus.NOT_FOUND.value());
			res.setMessage(exc.getMessage());
			res.setTimeStamp(System.currentTimeMillis());
			// create Response Entity
			ResponseEntity<StudentErrorResponse> entity = new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			
			return entity;
		
		}
		
		// add another exception handler... to catch any exception (catch all)
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			StudentErrorResponse res = new StudentErrorResponse();
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			res.setMessage(exc.getMessage());
			res.setTimeStamp(System.currentTimeMillis());
			
			// create Response Entity
			ResponseEntity<StudentErrorResponse> entity = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			
			return entity;
		}

}
