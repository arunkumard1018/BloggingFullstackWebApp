package com.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.exceptions.UserNotFoundException;
import com.app.model.UserDetails;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UsersResourceController {

	private UserService userService;

	public UsersResourceController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(path = "/users")
	public List<UserDetails> retriveAllUsers() {
		return userService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public UserDetails retriveUser(@PathVariable Integer id) {
		Optional<UserDetails> user = userService.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			return user.get();
		}
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		Optional<UserDetails> user = userService.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			userService.deleteById(id);
		}
	}

	@PostMapping(path = "/users")
	public ResponseEntity<UserDetails> createUser(@Valid @RequestBody UserDetails user) {
		UserDetails savedUser = userService.save(user);

		/**
		 * getting current uri => path ServletUriComponentsBuilder.fromCurrentRequest()
		 * adding path => .path("/{id}") replacing id with saved user id =>
		 * .buildAndExpand(savedUser.getId()) building the uri => .toUri()
		 * ResponseEntity is used to send response status 201 as created
		 */
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
