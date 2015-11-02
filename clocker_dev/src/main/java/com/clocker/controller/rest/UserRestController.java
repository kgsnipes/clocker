package com.clocker.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clocker.constants.ClockerConstants;
import com.clocker.dto.UserDTO;
import com.clocker.service.UserService;

@RestController
@RequestMapping("/user") 
public class UserRestController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Secured({"ROLE_ADMIN,ROLE_SUPERUSER"})
	@RequestMapping(value = "/add", method = RequestMethod.GET)  
	 public Boolean createUser(HttpSession session,UserDTO userDTO) {  
		try
		{
			UserDTO loggedInUser=(UserDTO)session.getAttribute(ClockerConstants.SESSION_USER_KEY);
			userService.createUser(userDTO, loggedInUser.getEmail());
			return Boolean.TRUE;
		}
		catch(Exception ex)
		{
			return Boolean.FALSE;
		}

	 }  

}
