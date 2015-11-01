package com.clocker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.clocker.dao.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByEmail(String email);

}
