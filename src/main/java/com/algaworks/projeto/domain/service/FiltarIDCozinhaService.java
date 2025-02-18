package com.algaworks.projeto.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;

@Service
public class FiltarIDCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public ResponseEntity<Optional<CozinhaEntity>> filtroId(Long id) {

		System.err.println(id);

		Optional<CozinhaEntity> cozinha = cozinhaRepository.findById(id);

		if (cozinha != null)
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
}
