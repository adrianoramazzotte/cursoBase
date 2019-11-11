package com.ramazzotte.estudoBase.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ramazzotte.estudoBase.domain.dto.EmailDTO;
import com.ramazzotte.estudoBase.security.JWTUtil;
import com.ramazzotte.estudoBase.security.UserSS;
import com.ramazzotte.estudoBase.services.AuthService;
import com.ramazzotte.estudoBase.services.UserService;
@RestController
@RequestMapping(value="/auth")
public class AuthResouce {
	
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshtoken(HttpServletResponse reponse){
		UserSS user= UserService.authenticated();
		String  token = jwtUtil.generateToken(user.getUsername());
		reponse.addHeader("Authorization","Bearer "+token);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDTO){
		service.sendNewPassword(objDTO.getEmail());
		return ResponseEntity.noContent().build();
	}

}
