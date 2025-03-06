package com.algaworks.projeto.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.CidadeEntity;

public interface CidadeRepository extends JpaRepository<CidadeEntity, UUID>{

	Optional<CidadeEntity> findByNome(String nome);
	
	Optional<CidadeEntity> findByEstadoId(UUID estadoId);
	
}
