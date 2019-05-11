package com.boraji.tutorial.springboot.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserSecurityEntity, Long> {
	
	UserSecurityEntity findByUserName(String userName);

}
