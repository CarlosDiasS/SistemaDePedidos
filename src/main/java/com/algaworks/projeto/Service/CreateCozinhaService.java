package com.algaworks.projeto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;

@Service
public class CreateCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public CozinhaEntity createCozinha(CozinhaEntity cozinha) {
	return cozinhaRepository.save(cozinha);
	
	
	}
}
