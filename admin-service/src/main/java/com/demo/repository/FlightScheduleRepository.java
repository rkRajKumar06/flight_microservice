package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.FlightSchedule;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

}
