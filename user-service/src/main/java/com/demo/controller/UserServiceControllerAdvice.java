package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.service.UserServiceException;

@ControllerAdvice
public class UserServiceControllerAdvice {
	
	@ExceptionHandler(UserServiceException.class)
	public ResponseEntity<String> handleUserServiceException(UserServiceException exception){
		return new ResponseEntity<String>("Exception Occurred", HttpStatus.BAD_REQUEST);
	}
}
