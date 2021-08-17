package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Airlines;
import com.demo.model.FlightDetails;
import com.demo.repository.AirlinesRepository;

@Service
public class AirlinesService {
	
	@Autowired
	private AirlinesRepository repository;
	
	@Autowired
	private FlightDetailsService detailsService;
	
	@Autowired
	private FlightScheduleService scheduleService;
	
	public List<Airlines> getAllAirlines(){
		return repository.findAll();
	}
	
	public Optional<Airlines> findById(int id) {
		return repository.findById(id);
	}
	
	public Airlines saveAirlines(Airlines entity) {
		return repository.save(entity);
	}
	
	public Airlines updateAirlinesStatus(int id, Airlines entity) {
		Optional<Airlines> obj = repository.findById(id);
		System.out.println(" Airlines "+id);
		if(obj.isPresent()) {
			obj.get().setBlocked(entity.isBlocked());
			detailsService.updateFlightStatus(entity.isBlocked(), id);
			List<FlightDetails> dataList = detailsService.findAllFlightDetailsBasedOnAirlinesId(id);
			if(dataList!=null && !dataList.isEmpty()) {
				for(FlightDetails flightObj : dataList) {
					scheduleService.updateTheStatus(entity.isBlocked(), flightObj.getId());
				}
			}
			return repository.save(obj.get());
		}else {
			throw new AdminServiceException();
		}
		
	}

}
