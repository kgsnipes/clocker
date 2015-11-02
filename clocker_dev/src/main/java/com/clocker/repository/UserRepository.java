package com.clocker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clocker.dao.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByEmail(String email);
	public List<User> findByRoles(String role);

}
