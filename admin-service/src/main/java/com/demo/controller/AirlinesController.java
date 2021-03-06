package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Airlines;
import com.demo.service.AirlinesService;

@CrossOrigin
@RestController
@RequestMapping("/airlines")
public class AirlinesController {
	
	@Autowired
	private AirlinesService airlinesService;
	
	@GetMapping("")
	@Cacheable(value = "airlines")
	public ResponseEntity<List<Airlines>> getAllAirlines(){
		return new ResponseEntity<List<Airlines>>(airlinesService.getAllAirlines(), HttpStatus.OK);
	}
	
	@PostMapping("")
	@CacheEvict(value = "airlines", allEntries = true)
	public ResponseEntity<Airlines> saveAirlines(@RequestBody Airlines entity){
		return new ResponseEntity<Airlines>(airlinesService.saveAirlines(entity), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value = "airlines", allEntries = true)
	public ResponseEntity<Airlines> updateAirlinesStatus(@PathVariable int id, @RequestBody Airlines entity){
		return new ResponseEntity<Airlines>(airlinesService.updateAirlinesStatus(id, entity), HttpStatus.OK);
	}
	
}
