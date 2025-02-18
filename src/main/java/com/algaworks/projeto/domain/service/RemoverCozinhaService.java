package com.algaworks.projeto.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.algaworks.projeto.model.repository.CozinhaRepository;

@Service
public class RemoverCozinhaService {

	private CozinhaRepository cozinhaRepository;
	
	public String remover(@PathVariable Long id) {
		cozinhaRepository.deleteById(id);
		System.err.println("Cozinha deletada " + id);
		return "Cozinha de id " + id + " deletada";
	}
	
}
