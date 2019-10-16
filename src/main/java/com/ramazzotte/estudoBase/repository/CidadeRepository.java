package com.ramazzotte.estudoBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramazzotte.estudoBase.domain.Cidade;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	

	
}
