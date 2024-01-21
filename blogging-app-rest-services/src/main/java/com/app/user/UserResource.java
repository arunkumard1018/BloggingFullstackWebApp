package com.app.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	public UserResource(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}
	
	@GetMapping(path = "/users")
	public List<User> retriveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retriveUser(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		if( user == null) {
			throw new UserNotFoundException("id: "+id);
		}else {
			return user;
		}
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		
		/**
		 * getting current uri => path ServletUriComponentsBuilder.fromCurrentRequest()
		 * adding path => .path("/{id}")
		 * replacing id with saved user id => .buildAndExpand(savedUser.getId())
		 * building the uri => .toUri()
		 * 
		 * ResponseEntity is used to send response status 201 as created
		 * */
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		if( user == null) {
			throw new UserNotFoundException("id: "+id);
		}else {
			userDaoService.deleteById(id);
		}
	}

}
