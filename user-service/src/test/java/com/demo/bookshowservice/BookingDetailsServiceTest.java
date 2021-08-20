package com.demo.bookshowservice;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.BookingDetails;
import com.demo.repository.BookingDetailsRepository;
import com.demo.repository.PassengersRepository;
import com.demo.service.BookingDetailsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class BookingDetailsServiceTest {

	@InjectMocks
	private BookingDetailsService bookingDetailsService;
	
	@Mock
	private BookingDetailsRepository bookingDetailsRepository;
	
	@Mock
	private PassengersRepository passengersRepository;
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForHistory_success() {
		String emailId = "test@gmail.com";
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setId(3);
		bookingDetails.setPnr("PNR12232");
		bookingDetails.setEmail(emailId);
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId)).thenReturn(Collections.singletonList(bookingDetails));
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId);
		
		assertEquals(1, result.size());
		assertEquals(emailId, result.get(0).getEmail());
		assertEquals("PNR12232", result.get(0).getPnr());
		
	}
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForHistory_emptyList() {
		String emailId = "test@gmail.com";
		
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId)).thenReturn(new ArrayList<BookingDetails>());
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId);
		assertNotEquals(null, result);
		assertEquals(0, result.size());
		
	}
	
	
}
