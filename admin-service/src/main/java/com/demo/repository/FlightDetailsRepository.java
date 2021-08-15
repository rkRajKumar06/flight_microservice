package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {

}
