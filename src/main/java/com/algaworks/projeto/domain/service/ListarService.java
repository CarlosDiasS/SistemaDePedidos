package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;
import com.algaworks.projeto.model.repository.RestauranteRepository;

@Service
public class ListarService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<RestauranteEntity> restaurantes() {
		return restauranteRepository.findAll();

	}

	public Optional<RestauranteEntity> restaurante(UUID id) {
		try {
			return restauranteRepository.findById(id);
		} catch (EmptyResultDataAccessException e) {
			System.out.printf("restaurante de id %d inexistente", id);
			return Optional.empty();
		}
	}

	public List<CozinhaEntity> cozinhas() {
		return cozinhaRepository.findAll();

	}

	public Optional<CozinhaEntity> query(@RequestParam String nome) {
		System.err.println(nome);
		return cozinhaRepository.findByNome(nome);
	}
}