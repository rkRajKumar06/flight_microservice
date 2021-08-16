package com.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.FlightSchedule;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

	@Query(value="update flight_schedule set blocked=? where flightDetails=?", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateFlightSchedule(boolean value, int id);
}
