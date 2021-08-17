package com.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.FlightSchedule;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

	@Query(value="update flight_schedule set blocked=? where flight_details=?", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateFlightSchedule(boolean value, int id);
	
	@Query(value="select * from flight_schedule where from_place=? and to_place=? and (day='daily' or day=?) and available_business_class_seats>=? and available_economy_class_seats>=? and blocked=0", nativeQuery = true)
	public List<FlightSchedule> findSearchResults(String fromPlace, String toPlace, String day, int businessClassSeats, int economyClassSeats);
}
