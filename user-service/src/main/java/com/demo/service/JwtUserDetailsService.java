package com.demo.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.model.UserEntity;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println(" in loadby user--"+username);
        // spring-security will find user from db
        // you can write jdbc code
    	Optional<UserEntity> user = Optional.ofNullable(service.getUserByName(username));

		if (user.isPresent()) {
			System.out.println(" user present--"+username);
			// return new User("demo", "{noop}demo@123", new ArrayList<>());
			// return new User("demo", "{bcrypt}$2a$10$HpRDgXNLCa22nW4eCQuETuB4qOu02.Lln/qyugx3Kw3jtP.Xy7JvS", new ArrayList<>());
			return new User(user.get().getName(), user.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
    
    public String getRole(String username) {
		Optional<UserEntity> user = Optional.ofNullable(service.getUserByName(username));
		String roles = user.get().getRole();
		return roles;

	}
    
    public UserEntity save(UserEntity user) {
    	user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return service.save(user);
	}

}