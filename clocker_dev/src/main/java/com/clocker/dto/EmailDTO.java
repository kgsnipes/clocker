package com.clocker.dto;

import java.util.List;

public class EmailDTO {
	
	private List<String> recipients;
	private List<String> cc;
	private List<String> bcc;
	private String replyTo;
	
	private String subject;
	private String body;
	private String html;
	private List<EmailAttachmentDTO> attachments;
	
	public List<String> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	public List<String> getCc() {
		return cc;
	}
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	public List<String> getBcc() {
		return bcc;
	}
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	public String getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public List<EmailAttachmentDTO> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<EmailAttachmentDTO> attachments) {
		this.attachments = attachments;
	}
	
	
	
	
	

}
