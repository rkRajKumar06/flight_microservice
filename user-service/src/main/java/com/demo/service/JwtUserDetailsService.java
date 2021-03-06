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
			System.out.println(" user present--"+user.get().getEmail());
			return new User(user.get().getName(), user.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
    
    public UserEntity getUserObject(String username) {
    	Optional<UserEntity> user = Optional.ofNullable(service.getUserByName(username));
    	return user.get();
    }
    
//    public String getRole(String username) {
//		Optional<UserEntity> user = Optional.ofNullable(service.getUserByName(username));
//		String roles = user.get().getRole();
//		return roles;
//	}
//    
//    public String getEmail(String username) {
//		Optional<UserEntity> user = Optional.ofNullable(service.getUserByName(username));
//		String email = user.get().getEmail();
//		return email;
//	}
    
    public UserEntity save(UserEntity user) {
    	user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return service.save(user);
	}

}