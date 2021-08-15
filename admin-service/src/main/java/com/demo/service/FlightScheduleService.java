package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.FlightScheduleRepository;

@Service
public class FlightScheduleService {
	
	@Autowired
	private FlightScheduleRepository repository;

}
