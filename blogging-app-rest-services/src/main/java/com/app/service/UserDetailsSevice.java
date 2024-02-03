package com.app.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.app.entity.UserDetailsEntity;
import com.app.jpa.UserDetailsRepository;

@Service
public class UserDetailsSevice {
	private UserDetailsRepository userDetailsRepository;

	public UserDetailsSevice(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}
	
	public UserDetailsEntity addUser(String name) {
		UserDetailsEntity userDetails = new UserDetailsEntity();
		userDetails.setName(name);
		return userDetailsRepository.save(userDetails);
	}

	public Optional<UserDetailsEntity> findById(Long id) {
		return userDetailsRepository.findById(id);
	}


	public Optional<UserDetailsEntity> findByEmail(String username) {
		return userDetailsRepository.findById((long)1);
	}
}
