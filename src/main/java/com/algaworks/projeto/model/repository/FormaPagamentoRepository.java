package com.algaworks.projeto.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.FormaPagamentoEntity;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, UUID> {

	
	
}
