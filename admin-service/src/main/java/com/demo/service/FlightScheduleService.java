package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.FlightSchedule;
import com.demo.repository.FlightScheduleRepository;

@Service
public class FlightScheduleService {
	
	@Autowired
	private FlightScheduleRepository repository;

	public List<FlightSchedule> findAllFlightSchedule(){
		return repository.findAll();
	}
	
	public FlightSchedule saveFlightSchedule(FlightSchedule entity) {
		return repository.save(entity);
	}
	
	public FlightSchedule updateFlightSchedule(int id, FlightSchedule entity) {
		Optional<FlightSchedule> obj = repository.findById(id);
		if(obj.isPresent()) {
			entity.setId(id);
			return repository.save(entity);
		}else {
			throw new AdminServiceException();
		}
	}
	
	public void updateTheStatus(boolean value, int id) {
		repository.updateFlightSchedule(value, id);
	}
}
