package com.algaworks.projeto.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.projeto.model.entity.CozinhaEntity;

@Repository
public interface CozinhaRepository extends JpaRepository<CozinhaEntity, Long>{

	//metodos extras
	
	Optional<CozinhaEntity> findByNome(String nome);
	
	Optional<CozinhaEntity> findById(long id);
	
	
	 
}
