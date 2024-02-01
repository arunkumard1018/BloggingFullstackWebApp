package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.UserDetailsEntity;
import com.app.entity.UserEntity;
import com.app.exceptions.UserNotFoundException;
import com.app.jpa.UserRepository;
import com.app.model.User;

@Service
public class AuthenticationService implements UserDetailsService{

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthenticationService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserEntity register(User user,UserDetailsEntity userDetails) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setRoles(user.getRoles());
		userEntity.setAccountActive(true);
		userEntity.setUserdetails(userDetails);
		return userRepository.save(userEntity);
	}

	public List<UserEntity> retriveRegisteredUsers() {
		return userRepository.findAll();
	}
	public Optional<UserEntity> retriveUsers(Long id) {
		return userRepository.findById(id);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByEmail(username);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("user Not Found :" + username);
		}
		
		return user.get();
	}
	
	public String retriveEmailForId(Long id) {
		Optional<UserEntity> user =  userRepository.findById(id);
		if(user.isEmpty()) throw new UserNotFoundException("Id :"+id);
		return user.get().getEmail();
	}
	
}
