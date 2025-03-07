package com.algaworks.projeto.model.repository;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.ProdutoEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;


public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID>{

	Optional<ProdutoEntity> findByNome(String nome);
	
	java.util.List<ProdutoEntity> findByRestaurante(RestauranteEntity restaurante);

	List<ProdutoEntity> findByRestaurante(Optional<RestauranteEntity> aux);
	
	
}
