package com.demo.service;

public class UserServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public UserServiceException(){
		
	}
	
	public UserServiceException(String message){
		this.message = message;
	}
}
