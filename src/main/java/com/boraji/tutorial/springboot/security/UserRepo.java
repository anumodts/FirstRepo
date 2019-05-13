package com.boraji.tutorial.springboot.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boraji.tutorial.springboot.entity.UserDetailsEntity;

public interface UserRepo extends JpaRepository<UserDetailsEntity, String> {
	
	UserDetailsEntity findByuserName(String userName);

	
}
