package com.ramazzotte.estudoBase.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.ramazzotte.estudoBase.domain.Pedido;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);
	void sendOrderConfirmationEmail(Pedido obj);
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage msg);
	
	

}
