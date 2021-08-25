package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BookedSeats;
import com.demo.model.BookingDetails;
import com.demo.service.BookingDetailsService;
import com.demo.service.UserServiceException;

@CrossOrigin
@RestController
@RequestMapping("/bookingDetails")
public class BookingDetailsController {
	
	@Autowired
	private BookingDetailsService service;
	
	@Autowired
	private KafkaTemplate<String, BookedSeats> kafkaTemplate;
	
	private final String TOPIC = "UpdateAvailableSeats";

	@GetMapping("/history/{emailId}")
	public ResponseEntity<List<BookingDetails>> findAllBookingDetailsForHistory(@PathVariable String emailId){
		return new ResponseEntity<List<BookingDetails>>(service.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/manage/{emailId}")
	public ResponseEntity<List<BookingDetails>> findAllBookingDetailsForManageBooking(@PathVariable String emailId){
		return new ResponseEntity<List<BookingDetails>>(service.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingDetails> findBookingDetailsById(@PathVariable int id) {
		Optional<BookingDetails> data = service.findBookDetailsById(id);
		if(data.isPresent()) {
			return new ResponseEntity<BookingDetails>(data.get(), HttpStatus.OK);
		}
		throw new UserServiceException();
	}
	
	@PostMapping("")
	public ResponseEntity<BookingDetails> saveBookingDetails(@RequestBody BookingDetails details){
		BookingDetails obj = service.saveBookingDetails(details);
		if(null!=obj) {
			BookedSeats bookedSeats = new BookedSeats();
			bookedSeats.setScheduleID(details.getFlightSchedule1());
			bookedSeats.setBookedSeats(details.getNoOfPersons());
			bookedSeats.setClasstype(details.getSeatClass());
			kafkaTemplate.send(TOPIC, bookedSeats);
			if(details.getFlightSchedule2()!=0) {
				bookedSeats = new BookedSeats();
				bookedSeats.setScheduleID(details.getFlightSchedule2());
				bookedSeats.setBookedSeats(details.getNoOfPersons());
				bookedSeats.setClasstype(details.getSeatClass());
				kafkaTemplate.send(TOPIC, bookedSeats);
			}
		}
		return new ResponseEntity<BookingDetails>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<BookingDetails> cancelBookingDetails(@PathVariable int id, @RequestBody BookingDetails details){
		return new ResponseEntity<BookingDetails>(service.saveBookingDetails(details), HttpStatus.OK);
	}
	
	
}
