package com.demo.bookshowservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.BookingDetails;
import com.demo.model.Passengers;
import com.demo.repository.BookingDetailsRepository;
import com.demo.repository.PassengersRepository;
import com.demo.service.BookingDetailsService;
import com.demo.service.UserServiceException;

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
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForHistory_nullList() {
		String emailId = "test@gmail.com";
		
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId)).thenReturn(null);
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForHistory(emailId);
		assertEquals(null, result);
	}
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForManage_success() {
		String emailId = "test@gmail.com";
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setId(3);
		bookingDetails.setPnr("PNR12232");
		bookingDetails.setEmail(emailId);
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId)).thenReturn(Collections.singletonList(bookingDetails));
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId);
		
		assertEquals(1, result.size());
		assertEquals(emailId, result.get(0).getEmail());
		assertEquals("PNR12232", result.get(0).getPnr());
		
	}
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForManage_emptyList() {
		String emailId = "test@gmail.com";
		
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId)).thenReturn(new ArrayList<BookingDetails>());
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId);
		assertNotEquals(null, result);
		assertEquals(0, result.size());
		
	}
	
	@Test
	public void getBookingDetailsBasedOnEmailIdAndDateFilterForManage_nullList() {
		String emailId = "test@gmail.com";
		
		when(bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId)).thenReturn(null);
		
		List<BookingDetails> result = bookingDetailsService.getBookingDetailsBasedOnEmailIdAndDateFilterForManage(emailId);
		assertEquals(null, result);
	}
	
	@Test
	public void saveBookingDetails_success() {
		BookingDetails entity = new BookingDetails();
		List<Passengers> entities = new ArrayList<Passengers>();
		entity.setPassengerList(entities);
		when(passengersRepository.saveAllAndFlush(entities)).thenReturn(entities);
		when(bookingDetailsRepository.save(entity)).thenReturn(entity);
		
		BookingDetails result = bookingDetailsService.saveBookingDetails(entity);
		assertNotEquals(null, result);
		assertNotEquals(null, result.getPassengerList());
	}
	
	@Test
	public void updateBookingDetails_idPresent() {
		BookingDetails obj = new BookingDetails();
		obj.setEmail("test@gmail.com");
		obj.setId(2);
		obj.setCancelled(false);
		when(bookingDetailsRepository.findById(2)).thenReturn(Optional.of(obj));
		when(bookingDetailsRepository.save(obj)).thenReturn(obj);
		
		BookingDetails result = bookingDetailsService.updateBookingDetails(2, obj);
		assertNotEquals(null, result);
		assertEquals("test@gmail.com", result.getEmail());
		assertEquals(2, result.getId());
		assertEquals(true, result.isCancelled());
	}
	
	@Test
	public void updateBookingDetails_idNotPresent() {
		BookingDetails obj = new BookingDetails();
		obj.setId(2);
		when(bookingDetailsRepository.findById(2)).thenThrow(new IllegalArgumentException());
		try{
			bookingDetailsService.updateBookingDetails(1, obj);
		}catch(Exception e) {
			assertEquals(UserServiceException.class, e.getClass());
		}
	}
	
	@Test
	public void findBookDetailsById_failure() {
		when(bookingDetailsRepository.findById(2)).thenThrow(new IllegalArgumentException());
		
		try{
			bookingDetailsService.findBookDetailsById(1);
		}catch(Exception e) {
			assertEquals(UserServiceException.class, e.getClass());
		}
	}
	
	@Test
	public void findBookDetailsById_success() {
		BookingDetails obj = new BookingDetails();
		obj.setId(2);
		when(bookingDetailsRepository.findById(2)).thenReturn(Optional.of(obj));
		
		Optional<BookingDetails> result = bookingDetailsService.findBookDetailsById(2);
		assertNotEquals(null, result.get());
		assertEquals(true, result.isPresent());
		assertEquals(2, result.get().getId());
	}
}
