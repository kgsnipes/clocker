package com.clocker.service.impl;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.clocker.dao.User;
import com.clocker.dto.ForgotPasswordEmailContext;
import com.clocker.exception.TokenExpiredException;
import com.clocker.exception.UserNotFoundException;
import com.clocker.service.ForgotPasswordService;
import com.clocker.service.UserService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component(value="forgotPasswordService")
public class DefaultForgotPasswordService implements ForgotPasswordService {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("forgotPasswordEmailService")
	private ForgotPasswordEmailService forgotPasswordEmailService;
	
	@Override
	public void sendForgotPasswordEmail(String email)throws UserNotFoundException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		User user=userService.getUserByEmail(email);
		if(user!=null)
		{
			ForgotPasswordEmailContext forgotPasswordEmailContext=new ForgotPasswordEmailContext();
			HashMap emailTemplateContent=new HashMap();
			emailTemplateContent.put("name", email);
			forgotPasswordEmailContext.setUser(user);
			forgotPasswordEmailContext.setEmailTemplateContent(emailTemplateContent);
			forgotPasswordEmailService.sendForgotPasswordEmail(forgotPasswordEmailContext);
		}
		else
		{
			throw new UserNotFoundException("User is not found");
		}
		
	}
	

	@Override
	public void updatePasswordForUser(String email, String token,
			String password) throws TokenExpiredException,
			UserNotFoundException {
		// TODO Auto-generated method stub

	}

}
