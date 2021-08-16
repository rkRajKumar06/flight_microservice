package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.FlightDetails;
import com.demo.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {
	
	@Autowired
	private FlightDetailsRepository repository;
	
	public List<FlightDetails> findAllFlightDetails(){
		return repository.findAll();
	}
	
	public FlightDetails saveFlightDetails(FlightDetails entity){
		return repository.save(entity);
	}

	public void updateFlightStatus(boolean value, int id) {
		repository.updateFlightStatus(value, id);
	}
}
