package com.clocker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clocker.dao.User;
import com.clocker.dto.UserDTO;
import com.clocker.repository.UserRepository;
import com.clocker.service.UserService;

public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void createUser(UserDTO userDto) {
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

}
