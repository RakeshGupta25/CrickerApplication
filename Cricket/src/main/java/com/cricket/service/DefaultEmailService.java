package com.cricket.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cricket.entity.MailDetails;
import com.cricket.repository.MailRepository;

@Service
public class DefaultEmailService implements EmailService {

	@Autowired
	public JavaMailSender javaMailSender;

	@Autowired
	private MailRepository mailRepository;

	@Value("${spring.mail.username}")
	private String sender;

//	@Override
//	public void addEmail(MailDetails mailDetails) {
//		mailDetails.setFrom(sender);
//		mailDetails.setSentDate(new Date());
//		mailRepository.save(mailDetails);
//	}

	@Override
	public List<MailDetails> getAllEmail() {

		return mailRepository.findAll();
	}

	Date date = new Date();

	@Override
	public void sendEmail(MailDetails mailDetails) {

		try {

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(sender);
			mailDetails.setFroms(sender);
			simpleMailMessage.setSentDate(date);
			mailDetails.setSentDate(date);
			simpleMailMessage.setTo(mailDetails.getRecipient());
			simpleMailMessage.setSubject(mailDetails.getSubject());
			simpleMailMessage.setText(mailDetails.getMsgBody());
			System.out.println(simpleMailMessage);
			mailRepository.save(mailDetails);
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail Sent Successfully...");

		} catch (Exception e) {
			System.out.println("Error while Sending Mail");
		}
	}

	@Override
	public void sendEmailWithAttachment(MailDetails mailDetails) throws MessagingException, FileNotFoundException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		messageHelper.setFrom(sender);
		mailDetails.setFroms(sender);
		messageHelper.setSentDate(date);
		mailDetails.setSentDate(date);

		messageHelper.setTo(mailDetails.getRecipient());
		messageHelper.setSubject(mailDetails.getSubject());
		messageHelper.setText(mailDetails.getMsgBody());
		FileSystemResource file = new FileSystemResource(new File(mailDetails.getAttachment()));
		boolean check = file.exists();
		System.out.println(check);
		messageHelper.addAttachment("Purchase Order", file);
		javaMailSender.send(mimeMessage);
	}

}