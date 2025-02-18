package com.algaworks.projeto.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity, UUID> {

	
	
	
}
