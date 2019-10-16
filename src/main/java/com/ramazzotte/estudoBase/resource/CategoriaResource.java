package com.ramazzotte.estudoBase.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}

}
