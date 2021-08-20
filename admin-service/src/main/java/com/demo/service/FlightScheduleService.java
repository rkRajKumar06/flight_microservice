package com.demo.service;

import java.time.LocalDate;
import java.util.Arrays;
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
	
	public Optional<FlightSchedule> findAllFlightScheduleBasedOnId(int id){
		return repository.findById(id);
	}
	
	public FlightSchedule saveFlightSchedule(FlightSchedule entity) {
		return repository.save(entity);
	}
	
	public FlightSchedule updateFlightSchedule(int id, FlightSchedule entity) {
		Optional<FlightSchedule> obj = repository.findById(id);
		if(obj.isPresent()) {
			obj.get().setArrivalTime(entity.getArrivalTime());
			obj.get().setDepartureTime(entity.getDepartureTime());
			obj.get().setDay(entity.getDay());
			obj.get().setFromPlace(entity.getFromPlace());
			obj.get().setToPlace(entity.getToPlace());
			obj.get().setPrice(entity.getPrice());
			obj.get().setFlightDetails(entity.getFlightDetails());
			return repository.save(obj.get());
		}else {
			throw new AdminServiceException();
		}
	}
	
	public void updateFlightScheduleAvailableSeats(FlightSchedule entity) {
		repository.save(entity);
	}
	
	public void updateTheStatus(boolean value, int id) {
		repository.updateFlightSchedule(value, id);
	}
	
	public List<FlightSchedule> searchFlightSchedule(String fromPlace, String toPlace, String departureDate, String seatClass, String noOfPassengers) {
		int businessClass=0, economyClass=0; 
		if("business".equalsIgnoreCase(seatClass)) {
			businessClass = Integer.parseInt(noOfPassengers);
		}else if("economy".equalsIgnoreCase(seatClass)){
			economyClass = Integer.parseInt(noOfPassengers);
		}
		LocalDate date = LocalDate.parse(departureDate);
		String day = date.getDayOfWeek().name();
		String frequency = "";
		List<String> weekDays = Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY");
		List<String> weekendDays = Arrays.asList("SUNDAY", "SATURDAY");
		if(weekDays.contains(day)) {
			frequency = "weekdays";
		}else if(weekendDays.contains(day)) {
			frequency = "weekends";
		}
		System.out.println(" Day of the week "+day);
		System.out.println(" Frequency "+frequency);
		return repository.findSearchResults(fromPlace, toPlace, frequency, businessClass, economyClass);
	}
}
