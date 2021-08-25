package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
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
