package com.clocker.service;

import java.io.IOException;

import com.clocker.exception.TokenExpiredException;
import com.clocker.exception.UserNotFoundException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public interface ForgotPasswordService {
	
	public void sendForgotPasswordEmail(String email)throws UserNotFoundException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException;
	public void updatePasswordForUser(String email,String token,String password)throws TokenExpiredException,UserNotFoundException;

}
