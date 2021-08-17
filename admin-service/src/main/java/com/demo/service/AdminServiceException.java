package com.demo.service;

public class AdminServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AdminServiceException() {}
	
	public AdminServiceException(String message) {
		super();
		this.message = message;
	}
	
}
