package com.clocker.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.clocker.dao.User;
import com.clocker.dto.UserDTO;
import com.clocker.exception.UserNotFoundException;

public interface UserService extends UserDetailsService{
	
	public void createUser(UserDTO user,String userCreated);
	public void updateUser(UserDTO user,String userModified);
	public void blockUser(UserDTO user,String userModified);
	public User getUserByEmail(String email);
	public List<User> getUsersByRole(String role,int page,int limit);
	public List<GrantedAuthority> getGrantedAuthorities(List<String> roles);
	

}
