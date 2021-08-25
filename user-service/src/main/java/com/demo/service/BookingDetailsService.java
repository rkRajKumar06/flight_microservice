package com.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.BookingDetails;
import com.demo.repository.BookingDetailsRepository;
import com.demo.repository.PassengersRepository;

@Service
public class BookingDetailsService {
	
	@Autowired
	private BookingDetailsRepository repository;
	
	@Autowired
	private PassengersRepository passengersRepository;
	
	public List<BookingDetails> getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(String emailId) {
		//need to check the date of booking to be in past
		LocalDate date = LocalDate.now();
		
		return repository.findBookingDetailsForHistory(emailId, date);
	}
	
	public List<BookingDetails> getBookingDetailsBasedOnEmailIdAndDateFilterForManage(String emailId) {
		//need to check the date of booking to be in future
		LocalDate date = LocalDate.now();
		System.out.println(" Date "+date+" email --"+emailId);
		return repository.findBookingDetailsForManage(emailId, date);
	}
	
	public BookingDetails saveBookingDetails(BookingDetails details) {
		details.setPassengerList(passengersRepository.saveAllAndFlush(details.getPassengerList()));
		return repository.save(details);
	}
	
	public BookingDetails updateBookingDetails(int id, BookingDetails details) {
		if(repository.findById(id).isPresent()) {
			details.setCancelled(true);
			return repository.save(details);
		}else {
			throw new UserServiceException();
		}
	}
	
	public Optional<BookingDetails> findBookDetailsById(int id) {
		return repository.findById(id);
	}
	

}
