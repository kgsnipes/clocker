package com.clocker.service;

import java.util.List;

import com.clocker.dao.User;
import com.clocker.dto.UserDTO;

public interface UserService {
	
	public void createUser(UserDTO user);
	public User getUserByEmail(String email);
	public List<User> getUsersByRole(String role);

}
