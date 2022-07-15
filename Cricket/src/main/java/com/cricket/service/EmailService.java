package com.cricket.service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.cricket.entity.MailDetails;

public interface EmailService {
	
	public List<MailDetails> getAllEmail();
	// void addEmail(MailDetails mailDetails);
	 void sendEmail(MailDetails mailDetails)throws Exception;
     void sendEmailWithAttachment(MailDetails mailDetails) throws MessagingException, FileNotFoundException;


}
