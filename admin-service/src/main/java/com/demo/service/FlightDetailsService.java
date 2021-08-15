package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {
	
	@Autowired
	private FlightDetailsRepository repository;

}
