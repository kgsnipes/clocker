package com.clocker.security;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.clocker.dao.User;
import com.clocker.service.UserService;

@Component
public class DefaultUserAuthenticationProvider implements AuthenticationProvider{

	private static final Logger log=Logger.getLogger(DefaultUserAuthenticationProvider.class.getName());
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		log.info("user name : "+authentication.getName());
		 String name = authentication.getName();
	     String password = authentication.getCredentials().toString();
	     //ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
	     //UserService userLoginService = (UserService) context.getBean("userService");
	     log.info("message : "+userService.getMessage());
	     User user=userService.getUserByEmail(name);
	     log.info("user entered : "+password);
	     log.info("database entered : "+user.getPassword());
	     if(name!= null && password!=null && password.equals(user.getPassword()))
	    	 return new UsernamePasswordAuthenticationToken(name, password,userService.getGrantedAuthorities(user.getRoles()) );
	     else
	    	 return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
