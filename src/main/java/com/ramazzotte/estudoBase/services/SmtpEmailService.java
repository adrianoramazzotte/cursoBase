package com.ramazzotte.estudoBase.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.ramazzotte.estudoBase.domain.Pedido;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javamailSender;

	private static final Logger Log = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		Log.info("Enviando Email...");
		Log.info("Enviando Email Html...");
		mailSender.send(msg);
		Log.info("Email enviado");

	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		Log.info("Enviando Email...");
		javamailSender.send(msg);
		Log.info("Email enviado");

	}

	

	

}