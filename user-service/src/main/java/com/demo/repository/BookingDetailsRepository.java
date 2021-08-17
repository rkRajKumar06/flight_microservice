package com.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.BookingDetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
	public List<BookingDetails> findByEmail(String email);
	
	@Query(value="select * from booking_details where email=? and departure_date<?", nativeQuery = true)
	public List<BookingDetails> findBookingDetailsForHistory(String email, LocalDate today); //manage and history
	
	@Query(value="select * from booking_details where email=? and departure_date>=?", nativeQuery = true)
	public List<BookingDetails> findBookingDetailsForManage(String email, LocalDate today); //manage and history
}
