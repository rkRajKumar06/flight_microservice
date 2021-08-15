package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Airlines;
import com.demo.repository.AirlinesRepository;

@Service
public class AirlinesService {
	
	@Autowired
	private AirlinesRepository repository;
	
	public List<Airlines> getAllAirlines(){
		return repository.findAll();
	}
	
	public Airlines saveAirlines(Airlines entity) {
		return repository.save(entity);
	}
	
	public Airlines updateAirlines(int id, Airlines entity) {
		Optional<Airlines> obj = repository.findById(id);
		if(obj.isPresent()) {
			entity.setId(id);
			return repository.save(entity);
		}else {
			throw new AdminServiceException();
		}
		
	}

}
