package com.demo.bookshowservice;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.UserEntity;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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
