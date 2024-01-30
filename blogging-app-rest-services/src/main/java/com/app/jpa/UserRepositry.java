package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.UserDetails;

public interface UserRepositry extends JpaRepository<UserDetails, Integer> {

}
