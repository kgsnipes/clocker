package com.clocker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.clocker.dao.User;
import com.clocker.dto.UserDTO;
import com.clocker.repository.UserRepository;
import com.clocker.service.UserService;

@Component(value="userService")
public class DefaultUserService implements UserService {
	
	private static final Logger log=Logger.getLogger(DefaultUserService.class.getName());

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@CachePut(cacheNames="users", key="#userDto.email")
	public void createUser(UserDTO userDto,String userCreated) {
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setRoles(userDto.getRoles());
		user.setCreatedBy(userCreated);
		user.setCreatedOn(new Date());
		user.setDisabled(false);
		
		userRepository.save(user);
	}

	@Override
	@Cacheable(cacheNames="users", key="#userDto.email")
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	@Cacheable(cacheNames="users", key="#role")
	public List<User> getUsersByRole(String role,int page,int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserDTO user, String userModified) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blockUser(UserDTO user, String userModified) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.info(username);
		User userDao=getUserByEmail(username);
		log.info(userDao.getEmail());
		log.info(userDao.getPassword());
		org.springframework.security.core.userdetails.UserDetails user = new org.springframework.security.core.userdetails.User(userDao.getEmail(), userDao.getPassword(), getGrantedAuthorities(userDao.getRoles()));
				
		return user;
	}

	@Override
	public List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> list=null;
		for(String role:roles)
		{
			if(list==null)
			{
				list=new ArrayList<GrantedAuthority>();
			}
			
			list.add(new SimpleGrantedAuthority(role));
			
		}
		
		return list;
	}

	

}
