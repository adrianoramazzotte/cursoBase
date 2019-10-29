package com.ramazzotte.estudoBase.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.ramazzotte.estudoBase.domain.Pedido;
public class MockEmailService extends AbstractEmailService {
	
	private static final Logger Log = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		Log.info("Simulando envio de Email...");
		Log.info(msg.toString());
		Log.info("Email enviado");

	}


	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		Log.info("Simulando envio de Email Html...");
		Log.info(msg.toString());
		Log.info("Email enviado");
<<<<<<< HEAD

	}


	

}
=======
		
	}

}
>>>>>>> a403130a6e2927add83cdc761fefe4a2bda59d15
