package com.app.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UserDetailsEntity;
import com.app.entity.UserEntity;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
//	Optional<UserDetailsEntity> findByUserId(Long id);
}
