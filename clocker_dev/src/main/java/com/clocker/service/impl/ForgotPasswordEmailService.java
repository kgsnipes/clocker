package com.clocker.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.clocker.dto.EmailDTO;
import com.clocker.dto.ForgotPasswordEmailContext;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component(value="forgotPasswordEmailService")
public class ForgotPasswordEmailService extends DefaultEmailService {
	
	private static final Logger log=Logger.getLogger(ForgotPasswordEmailService.class.getName());
	
	@Autowired
	private Configuration freemarkerConfiguration;
	
	@Value("${forgotpassword.emailtemplate.html}")
	private String emailTemplateHtml;
	@Value("${forgotpassword.emailtemplate.text}")
	private String emailTemplateText;
	
	
	/*private String emailTemplateHtml="forgotpassword-html-emailtemplate.fmt";
	
	private String emailTemplateText="forgotpassword-text-emailtemplate.fmt";
	*/
	public void sendForgotPasswordEmail(ForgotPasswordEmailContext forgotPasswordEmailContext) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException
	{
		 String html = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(emailTemplateHtml,"UTF-8"), forgotPasswordEmailContext.getEmailTemplateContent());
		 String text = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(emailTemplateText,"UTF-8"), forgotPasswordEmailContext.getEmailTemplateContent());
		 EmailDTO emailMessage=new EmailDTO();
		 emailMessage.setRecipients(Arrays.asList(new String[]{forgotPasswordEmailContext.getUser().getEmail()}));
		 emailMessage.setHtml(html);
		 emailMessage.setBody(text);
		 super.sendEmail(emailMessage);
		
	}
	
	

}
