package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.model.entity.CidadeEntity;
import com.algaworks.projeto.model.entity.EstadoEntity;
import com.algaworks.projeto.model.repository.CidadeRepository;
import com.algaworks.projeto.model.repository.EstadoRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/estados")
public class ControllerEstado {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public List<EstadoEntity> estados() {
		return estadoRepository.findAll();

	}

	@GetMapping("/{id}")
	public EstadoEntity findById(@PathVariable UUID id) {
		return estadoRepository.findById(id).
				orElseThrow(() -> new EntityNotFoundException("estado não encontrado"));
	}

	@GetMapping("/cidades/{id}")
	public CidadeEntity findCidadesByEstado(@RequestBody EstadoEntity estado) {
		return cidadeRepository.findByEstado(estado)
				.orElseThrow(() -> new EntityNotFoundException("estado não encontrado"));

	}

}
