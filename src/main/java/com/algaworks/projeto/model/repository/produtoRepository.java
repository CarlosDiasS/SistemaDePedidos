package com.algaworks.projeto.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.RestauranteEntity;
import com.algaworks.projeto.model.entity.produtoEntity;

public interface produtoRepository extends JpaRepository<produtoEntity, UUID>{

	Optional<produtoEntity> findByNome(String nome);
	
	
	
	
}
