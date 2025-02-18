package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.domain.service.CozinhaService;
import com.algaworks.projeto.domain.service.ListarService;
import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;

@RestController
@RequestMapping(value = "/querys")

public class ControllerQuery {

	@Autowired
	private ListarService listarRestaurantesService;

	@Autowired
	private CozinhaService cozinhaService;

	@Autowired
	private ListarService listarService;

	@GetMapping("/result")
	public Optional<CozinhaEntity> query(@RequestParam String nome) {
		return listarService.query(nome);
	}

	@GetMapping("/{id}")
	public CozinhaEntity filtroCozinha(@PathVariable UUID id) {
		return cozinhaService.cozinhaById(id);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerCozinha(@PathVariable UUID id) {
		cozinhaService.remover(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<CozinhaEntity> adicionarCozinha(@RequestBody CozinhaEntity cozinhaEntity) {
		return cozinhaService.adicionar(cozinhaEntity);
	}

	@GetMapping("/restaurantes")
	public List<RestauranteEntity> listarRestaurantes() {
		return listarService.restaurantes();
	}

	@GetMapping("/restaurantes/{id}")
	public RestauranteEntity filtroId(@PathVariable UUID id) {
		return listarRestaurantesService.restaurante(id);

	}

	@GetMapping("/cozinhas")
	public List<CozinhaEntity> cozinhas() {
		return listarService.cozinhas();

	}

}
