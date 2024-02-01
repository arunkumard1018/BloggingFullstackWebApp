package com.app.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);

}
