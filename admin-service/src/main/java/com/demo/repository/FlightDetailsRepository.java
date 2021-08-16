package com.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {
	
	@Query(value="update flight_details set blocked=? where airlines=?", nativeQuery=true)
	@Modifying
	@Transactional
	void updateFlightStatus(boolean value, int id);
}
