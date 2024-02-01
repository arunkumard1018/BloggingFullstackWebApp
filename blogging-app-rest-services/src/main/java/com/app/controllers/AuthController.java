package com.app.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserDetailsEntity;
import com.app.entity.UserEntity;
import com.app.model.User;
import com.app.service.AuthenticationService;
import com.app.service.UserDetailsSevice;
import com.app.util.UserRole;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	private AuthenticationService authService;
	private UserDetailsSevice userDetailsSevice;
	
	
	
	public AuthController(AuthenticationService authService, UserDetailsSevice userDetailsSevice) {
		super();
		this.authService = authService;
		this.userDetailsSevice = userDetailsSevice;
	}

	@GetMapping(path = "/basicauth")
	public String basicAuthToken() {
		return "SUCCESS";
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		Set<UserRole> roles = new HashSet<>(Arrays.asList(UserRole.ROLE_USER));
		user.setRoles(roles);
		UserDetailsEntity registeredUserDetails = userDetailsSevice.addUser(user.getName());
		authService.register(user,registeredUserDetails);
		return ResponseEntity.ok().build();
	}
	

}
