package com.boraji.tutorial.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boraji.tutorial.springboot.dao.UserDetailDao;
import com.boraji.tutorial.springboot.entity.UserDetailsEntity;

@Component
public class SpringBootService {
	
	@Autowired
	private UserDetailDao  userDetailDao;
	
	public void saveUser(UserDetailsEntity userDetailsEntity) {
		userDetailDao.addUser(userDetailsEntity);
		System.out.println("Create User");
	}

	public Boolean checkUser(String username) {
		boolean isUserExists=userDetailDao.checkUser(username);
		return isUserExists;
	}

	
}

