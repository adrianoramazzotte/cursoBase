package com.ramazzotte.estudoBase.services;

import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;

import com.ramazzotte.estudoBase.domain.Pedido;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);
	void sendOrderConfirmationEmail(Pedido obj);
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage msg);

	
	

}
