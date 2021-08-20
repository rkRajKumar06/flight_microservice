package com.demo.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private String role;
	private String email;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	public JwtResponse(String jwttoken,String role, String email) {
		this.jwttoken = jwttoken;
		this.role = role;
		this.email = email;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getEmail() {
		return this.email;
	}

}