package com.ramazzotte.estudoBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramazzotte.estudoBase.domain.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	

	
}
