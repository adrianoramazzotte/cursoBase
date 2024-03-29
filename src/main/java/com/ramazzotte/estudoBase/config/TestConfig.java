package com.ramazzotte.estudoBase.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ramazzotte.estudoBase.services.DBService;
import com.ramazzotte.estudoBase.services.EmailService;
import com.ramazzotte.estudoBase.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instatiateTesDatabase();
		
		return true;
	}
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
