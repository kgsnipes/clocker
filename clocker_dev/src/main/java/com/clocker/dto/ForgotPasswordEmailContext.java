package com.clocker.dto;

import java.util.HashMap;

import com.clocker.dao.User;

public class ForgotPasswordEmailContext {
	
	private HashMap emailTemplateContent;
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HashMap getEmailTemplateContent() {
		return emailTemplateContent;
	}
	public void setEmailTemplateContent(HashMap emailTemplateContent) {
		this.emailTemplateContent = emailTemplateContent;
	}
	
	
	

}
