package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.BookingDetails;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String greet(){
		System.out.println(" Finding all user... ");
		
		
		//ResponseEntity<List<Movie>> response = restTemplate.exchange("http://localhost:8989/api/movies/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {});
		//ResponseEntity<String> response = restTemplate.exchange("http://ADMIN-SERVICE", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
		//return response.getBody();
		return "Welcome";
	}
	
}
