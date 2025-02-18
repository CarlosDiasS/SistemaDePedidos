package com.algaworks.projeto.model.repository;

import java.util.Optional;
import java.util.UUID;

import com.algaworks.projeto.model.entity.RestauranteEntity;

public interface RestauranteRepository extends CustomRepository<RestauranteEntity, UUID>{

	Optional<RestauranteEntity> findByNome(String nome);
	
	Optional<RestauranteEntity> findById(UUID id);
	
		
}
