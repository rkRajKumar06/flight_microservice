package com.demo.bookshowservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.UserEntity;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void getUserByName() {
		when(repository.findByName("test")).thenReturn(new UserEntity());
		UserEntity userObj = service.getUserByName("test");
		assertNotEquals(null, userObj);
	}
	
	@Test
	public void save() {
		UserEntity user = new UserEntity();
		user.setId(1);
		when(repository.save(user)).thenReturn(user);
		UserEntity userObj = service.save(user);
		assertNotEquals(null, userObj);
		assertEquals(1, userObj.getId());
	}

}
