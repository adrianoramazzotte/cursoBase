package com.ramazzotte.estudoBase.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

<<<<<<< HEAD
import com.ramazzotte.estudoBase.domain.Pedido;

=======
>>>>>>> a403130a6e2927add83cdc761fefe4a2bda59d15
public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
<<<<<<< HEAD

	@Autowired
	private JavaMailSender javamailSender;

	private static final Logger Log = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		Log.info("Enviando Email...");
		Log.info("Enviando Email Html...");
		mailSender.send(msg);
		Log.info("Email enviado");

=======
	
	@Autowired
	private JavaMailSender javamailSender;
	
	private static final Logger Log = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		Log.info("Enviando Email Html...");
		mailSender.send(msg);
		Log.info("Email enviado");
		
>>>>>>> a403130a6e2927add83cdc761fefe4a2bda59d15
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		Log.info("Enviando Email...");
		javamailSender.send(msg);
		Log.info("Email enviado");
<<<<<<< HEAD

	}

	

	

}
=======
		
	}

}
>>>>>>> a403130a6e2927add83cdc761fefe4a2bda59d15
