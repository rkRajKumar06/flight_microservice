package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.service.AdminServiceException;

@ControllerAdvice
public class AdminControllerAdvice {

	@ExceptionHandler(AdminServiceException.class)
	public final ResponseEntity<String> handleException(AdminServiceException exception){
		return new ResponseEntity<String>("Exception Occurred", HttpStatus.BAD_REQUEST);
	}
	
}
