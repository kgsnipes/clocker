package com.clocker.service.impl;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clocker.dao.User;
import com.clocker.dto.UserDTO;
import com.clocker.service.BootstrapFragment;
import com.clocker.service.UserService;

@Component(value="customerBootstrapFragment")
public class CustomerDataBootstrapFragment implements BootstrapFragment {

	private static final Logger log=Logger.getLogger(CustomerDataBootstrapFragment.class.getName());
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void performTask() {
		log.info("Performing bootstrap activities");
		UserDTO user=new UserDTO();
		user.setEmail("admin");
		user.setPassword("nimda");
		user.setRoles(Arrays.asList(new String[]{"ROLE_SUPERUSER"}));;
		userService.createUser(user, "admin");
		User userModel=userService.getUserByEmail("admin");
		log.info(user.getEmail());
		log.info(user.getPassword());

	}

}
