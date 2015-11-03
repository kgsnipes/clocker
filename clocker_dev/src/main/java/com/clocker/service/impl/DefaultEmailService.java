package com.clocker.service.impl;

import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.clocker.dto.EmailAttachmentDTO;
import com.clocker.dto.EmailDTO;
import com.clocker.service.EmailService;

@Component
public class DefaultEmailService implements EmailService {
	
	private static final Logger log=Logger.getLogger(DefaultEmailService.class.getName());
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	public void sendEmail(EmailDTO emailDto) {
		
		try
		{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			if(emailDto.getRecipients()!=null)
				helper.setTo(emailDto.getRecipients().toArray(new String[emailDto.getRecipients().size()]));
			else
				throw new Exception("No recipient added");
			
			if(emailDto.getCc()!=null)
				helper.setCc(emailDto.getCc().toArray(new String[emailDto.getCc().size()]));
			
			if(emailDto.getBcc()!=null)
				helper.setBcc(emailDto.getBcc().toArray(new String[emailDto.getBcc().size()]));
			
			if(emailDto.getReplyTo()!=null)
				helper.setReplyTo(emailDto.getReplyTo());
			
			if(emailDto.getSubject()!=null)
				helper.setSubject(emailDto.getSubject());
			
			if(emailDto.getHtml()!=null && emailDto.getBody()!=null)
				helper.setText(emailDto.getBody(), emailDto.getHtml());
			
			if(emailDto.getAttachments()!=null)
			{
				for(EmailAttachmentDTO attachment:emailDto.getAttachments())
				{
					helper.addAttachment(attachment.getName(),new ByteArrayResource(attachment.getContent()));
				}
				
			}
	
			mailSender.send(message);
		}
		catch(Exception ex)
		{
			log.severe("exception in sending mail" + ex.getMessage());
		}

	}

}
