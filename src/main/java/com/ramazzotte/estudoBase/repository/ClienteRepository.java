package com.ramazzotte.estudoBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ramazzotte.estudoBase.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	 @Transactional(readOnly = true)
	  Cliente findByEmail(String email);

	
}
