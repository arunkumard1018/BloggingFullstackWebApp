package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app.jpa.UserRepositry;
import com.app.model.UserDetails;

@Service
public class UserService {
	
	private UserRepositry userRepositry;
	
	public UserService(UserRepositry userRepositry) {
		super();
		this.userRepositry = userRepositry;
	}
	
	public List<UserDetails> findAll(){
		return userRepositry.findAll();
	}
	
	public Optional<UserDetails> findById(Integer id) {
		return userRepositry.findById(id);
	}

	public UserDetails save(UserDetails user) {
		return userRepositry.save(user);
	}

	public void deleteById(Integer id) {
		userRepositry.deleteById(id);
		
	}

}
