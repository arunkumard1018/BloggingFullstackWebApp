package com.app.model;


import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.app.util.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class User {
	

	@Email(message = "Email Not Valid")
	@NotBlank
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
			message = "password Must contain at least 8 chars min 1 digit 1 lower case and one special char @#%$^ etc.)")
	@NotBlank
	private String password;
	
	@NotBlank
	@Length(min = 2, message = "name must be at least 2 chars long")
	private String name;

	
	private Set<UserRole> roles;
	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
		
	}

	public Set<UserRole> getRoles() {
		return roles;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + "]";
	}
	
		

}
