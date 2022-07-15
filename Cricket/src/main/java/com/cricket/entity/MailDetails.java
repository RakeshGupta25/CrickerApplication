package com.cricket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
public class MailDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mailId;

	@Nullable
	private String froms;

//	@Nullable
//	private String replyTo;

	@Nullable
	private String[] recipient;

//	@Nullable
//	private String[] cc;

	@Nullable
	private String attachment;

	@Nullable
	private Date sentDate;

	@Nullable
	private String subject;

	@Nullable
	private String msgBody;

	public MailDetails() {
		super();
	}

	public MailDetails(int mailId, String froms, String[] recipient, String attachment, Date sentDate, String subject,
			String msgBody) {
		super();
		this.mailId = mailId;
		this.froms = froms;
		this.recipient = recipient;
		this.attachment = attachment;
		this.sentDate = sentDate;
		this.subject = subject;
		this.msgBody = msgBody;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	

	public String[] getRecipient() {
		return recipient;
	}

	public void setRecipient(String[] recipient) {
		this.recipient = recipient;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String froms) {
		this.froms = froms;
	}

	

	
}
