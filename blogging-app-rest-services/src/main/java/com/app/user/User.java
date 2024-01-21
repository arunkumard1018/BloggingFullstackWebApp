package com.app.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;

public class User {

	private Integer id;
	@Min(value = 3,message = "name should be atleast 3 characters long")
	private String name;
	@Email
	private String email;
	private String password;
	@Past(message = "date of birth must be in past")
	private LocalDate dob;
	
	public User(int id, String name, String email, String password, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ "]";
	}
	
	
}
