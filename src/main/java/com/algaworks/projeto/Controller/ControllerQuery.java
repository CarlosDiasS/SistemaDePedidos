package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.Optional;

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

import com.algaworks.projeto.domain.service.AdicionarCozinhaService;
import com.algaworks.projeto.domain.service.ListarService;
import com.algaworks.projeto.domain.service.RemoverCozinhaService;
import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;

@RestController
@RequestMapping(value = "/querys")

public class ControllerQuery {

	@Autowired
	private ListarService listarRestaurantesService;

	@Autowired
	private AdicionarCozinhaService adicionarCozinhaService;

	@Autowired
	private RemoverCozinhaService removerCozinhaService;

	@Autowired
	private ListarService listarService;

	@GetMapping("/result")
	public Optional<CozinhaEntity> query(@RequestParam String nome) {
		return listarService.query(nome);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CozinhaEntity>> filtro(@PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/remover/{id}")
	public String removerCozinha(@PathVariable Long id) {
		return removerCozinhaService.remover(id);
	}

	@PostMapping
	public ResponseEntity<CozinhaEntity> adicionarCozinha(@RequestBody CozinhaEntity cozinhaEntity) {
		return adicionarCozinhaService.adicionar(cozinhaEntity);
	}

	@GetMapping("/restaurantes")
	public List<RestauranteEntity> listarRestaurantes() {
		return listarService.restaurantes();
	}
	
	@GetMapping("/restaurantes/{id}")
	public Optional<RestauranteEntity> filtroId(@PathVariable Long id){
		return listarRestaurantesService.restaurante(id);
	}
	
	
	@GetMapping("/cozinhas")
	public List<CozinhaEntity> cozinhas() {
		return listarService.cozinhas();

	}
	
//	@GetMapping("/filtro-cozinhas")
//	public List<RestauranteEntity> restaurantesComFreteGratisSpec(String nome){
//		var FreteGratis = new RestauranteComFreteGratisSpec();
//		var comNomeEqual = new RestauranteComNomeEqual(nome);
//		return RestauranteRepository.(FreteGratis.and(comNomeEqual));
//	}
	
	
	

}
