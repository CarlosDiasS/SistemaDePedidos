package com.algaworks.projeto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;

@Service
public class AdicionarCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	@PostMapping
	public ResponseEntity<CozinhaEntity> adicionar(@RequestBody CozinhaEntity cozinhaEntity) {
		CozinhaEntity novaCozinha = cozinhaRepository.saveAndFlush(cozinhaEntity);
		System.err.println("Cozinha adicionada: " + novaCozinha.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCozinha);
	}
	
}
