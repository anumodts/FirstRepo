package com.boraji.tutorial.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.springboot.entity.UserDetailsEntity;

@Transactional
@Repository
public class UserDetailDao {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public void addUser(UserDetailsEntity userDetailsEntity) {
		try {
		entityManager.persist(userDetailsEntity);
		}catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		
		
	}

	public boolean checkUser(String username) {
		UserDetailsEntity userDetailsEntity=entityManager.find(UserDetailsEntity.class, username);
		boolean result=false;
		if(null!=userDetailsEntity) {
			result=true;
		}
		return result;
			
		
	}

}
