package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.FlightDetails;
import com.demo.service.FlightDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/flightDetails")
public class FlightDetailsController {

	@Autowired
	private FlightDetailsService flightDetailsService;
	
	@GetMapping("")
	public ResponseEntity<List<FlightDetails>> getAllFlightDetails() {
		return new ResponseEntity<List<FlightDetails>>(flightDetailsService.findAllFlightDetails(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightDetails> getFlightDetailsById(@PathVariable int id) {
		return new ResponseEntity<FlightDetails>(flightDetailsService.findFlightDetailsById(id), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<FlightDetails> saveFlightDetails(@RequestBody FlightDetails flightDetails) {
		System.out.println(" receive the obj "+flightDetails.toString());
		return new ResponseEntity<FlightDetails>(flightDetailsService.saveFlightDetails(flightDetails), HttpStatus.OK);
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<List<FlightDetails>> getFlightDetailsBasedOnAirlinesId(@PathVariable int id){
		return new ResponseEntity<List<FlightDetails>>(flightDetailsService.findAllFlightDetailsBasedOnAirlinesId(id), HttpStatus.OK);
	}
}
