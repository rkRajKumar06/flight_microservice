package com.demo.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

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
	
	public FlightDetails findFlightDetailsById(int id){
		Optional<FlightDetails> obj = repository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}else {
			throw new AdminServiceException();
		}
		
	}
	
	public List<FlightDetails> findAllFlightDetailsBasedOnAirlinesId(int airlinesId){
		return repository.findByAirlines(airlinesId);
	}
	
	public FlightDetails saveFlightDetails(FlightDetails entity){
		return repository.save(entity);
	}

	public void updateFlightStatus(boolean value, int id) {
		repository.updateFlightStatus(value, id);
	}
}
