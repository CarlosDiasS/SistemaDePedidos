package com.algaworks.projeto.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public ResponseEntity<CozinhaEntity> adicionar(@RequestBody CozinhaEntity cozinhaEntity) {
		CozinhaEntity novaCozinha = cozinhaRepository.saveAndFlush(cozinhaEntity);
		System.err.println("Cozinha adicionada: " + novaCozinha.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCozinha);
	}

	public CozinhaEntity cozinhaById(@RequestParam UUID id) {
		return cozinhaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("cozinha não encontrada"));
	}

	public void remover(@PathVariable UUID id) {
		cozinhaRepository.deleteById(id);
		System.err.println("Cozinha deletada " + id);
	}


}
