package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.model.entity.EstadoEntity;
import com.algaworks.projeto.model.repository.EstadoRepository;

@RestController
@RequestMapping(value = "/estados")
public class ControllerEstado {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<EstadoEntity> estados() {

		return estadoRepository.findAll();

	}

	@GetMapping("/{id}")
	public Optional<EstadoEntity> findById(@PathVariable Long id) {
		return estadoRepository.findById(id);
	}

 }
