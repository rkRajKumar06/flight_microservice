package com.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BookedSeats;
import com.demo.model.FlightSchedule;
import com.demo.service.AdminServiceException;
import com.demo.service.FlightScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/schedule")
public class FlightScheduleController {
	
	@Autowired
	private FlightScheduleService scheduleService;
	
	@GetMapping("")
	public ResponseEntity<List<FlightSchedule>> getAllFlightSchedule(){
		return new ResponseEntity<List<FlightSchedule>>(scheduleService.findAllFlightSchedule(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightSchedule> getFlightScheduleBasedOnId(@PathVariable int id){
		Optional<FlightSchedule> result = scheduleService.findAllFlightScheduleBasedOnId(id);
		if(result.isPresent()) {
			return new ResponseEntity<FlightSchedule>(result.get(), HttpStatus.OK);
		}
		throw new AdminServiceException();
	}
	
	@PostMapping("")
	public ResponseEntity<FlightSchedule> saveFlightSchedule(@RequestBody FlightSchedule schedule){
		return new ResponseEntity<FlightSchedule>(scheduleService.saveFlightSchedule(schedule), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FlightSchedule> updateFlightSchedule(@PathVariable int id, @RequestBody FlightSchedule schedule){
		return new ResponseEntity<FlightSchedule>(scheduleService.updateFlightSchedule(id, schedule), HttpStatus.OK);
	}
	
	@PutMapping("/{value}/{flightId}")
	public ResponseEntity<FlightSchedule> updateFlightScheduleStatus(@PathVariable boolean value, @PathVariable int flightId){
		scheduleService.updateTheStatus(value, flightId);
		return new ResponseEntity<FlightSchedule>(HttpStatus.OK);
	}
	
	@KafkaListener(topics = "UpdateAvailableSeats", groupId = "group_id", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(BookedSeats bookedSeats) throws JsonProcessingException {
		System.out.println(" result "+new ObjectMapper().writeValueAsString(bookedSeats));
		
		// need to update the data.
		Optional<FlightSchedule> result = scheduleService.findAllFlightScheduleBasedOnId(bookedSeats.getScheduleID());
		if(result.isPresent()) {
			if(bookedSeats.getClasstype().equalsIgnoreCase("business")) {
				result.get().setAvailableBusinessClassSeats(result.get().getAvailableBusinessClassSeats() - bookedSeats.getBookedSeats());
			}else if(bookedSeats.getClasstype().equalsIgnoreCase("economy")) {
				result.get().setAvailableEconomyClassSeats(result.get().getAvailableEconomyClassSeats() - bookedSeats.getBookedSeats());
			}
			scheduleService.updateFlightScheduleAvailableSeats(result.get());
		}
	}
	
	@GetMapping("/search") //  for round trip we have to call this two times.
	public ResponseEntity<List<FlightSchedule>> searchResults(@QueryParam(value = "fromPlace") String fromPlace, @QueryParam(value = "toPlace") String toPlace,
			@QueryParam(value = "departureDate") String departureDate, @QueryParam(value = "seatClass") String seatClass, @QueryParam(value = "noOfPassengers") String noOfPassengers){
		System.out.println(" departure Date "+departureDate+"--from-"+fromPlace+"--to-"+toPlace+"--seat-"+seatClass+"--noofpass-"+noOfPassengers);
		
		return new ResponseEntity<List<FlightSchedule>>(scheduleService.searchFlightSchedule(fromPlace, toPlace, departureDate, seatClass, noOfPassengers), HttpStatus.OK);
	}

}
