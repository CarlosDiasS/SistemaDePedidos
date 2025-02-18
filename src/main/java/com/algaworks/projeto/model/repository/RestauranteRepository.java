package com.algaworks.projeto.model.repository;

import java.util.Optional;

import com.algaworks.projeto.model.entity.RestauranteEntity;

public interface RestauranteRepository extends CustomRepository<RestauranteEntity, Long>{

	Optional<RestauranteEntity> findByNome(String nome);
	
	Optional<RestauranteEntity> findById(long id);
	
		
}
