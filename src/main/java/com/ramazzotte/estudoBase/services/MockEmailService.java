package com.ramazzotte.estudoBase.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {
	
	private static final Logger Log = LoggerFactory.getLogger(MockEmailService.class);
	

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		Log.info("Simulando envio de Email...");
		Log.info(msg.toString());
		Log.info("Email enviado");
		
	}

}