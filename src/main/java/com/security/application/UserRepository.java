package com.security.application;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.application.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
	
}
