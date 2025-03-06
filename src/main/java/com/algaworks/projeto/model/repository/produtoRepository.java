package com.algaworks.projeto.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID>{

	Optional<ProdutoEntity> findByNome(String nome);
	
	
	
	
}
