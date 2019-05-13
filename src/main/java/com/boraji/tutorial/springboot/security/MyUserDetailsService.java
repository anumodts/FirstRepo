package com.boraji.tutorial.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boraji.tutorial.springboot.entity.UserDetailsEntity;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetailsEntity userDetailsEntity= userRepo.findByuserName(userName);
		if(userDetailsEntity==null) {
			throw new UsernameNotFoundException(userName+" not found");
		}
		
		return new UserPrincipal(userDetailsEntity);
	}


}

