package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.domain.service.RestauranteService;
import com.algaworks.projeto.domain.service.ServiceProjeto;
import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.ProdutoEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;

import Mappers.CozinhaMapper;
import Mappers.ProdutoMapper;
import Mappers.RestauranteMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import model.dto.CozinhaInputDto;
import model.dto.ProdutoInputDto;
import model.dto.RestauranteInputDto;

@RestController
@RequestMapping(value = "/restaurantes")
@AllArgsConstructor
public class RestauranteController {

	private RestauranteService restauranteService;

	private ServiceProjeto serviceProjeto;

	private CozinhaMapper cozinhaMapper;

	private RestauranteMapper restauranteMapper;

	private ProdutoMapper produtoMapper;

	@GetMapping("/cozinhas")
	public List<CozinhaEntity> cozinhas() {
		return restauranteService.GetCozinhas();
	}

	@GetMapping("/cozinhas/{id}")
	public CozinhaEntity filtroCozinha(@PathVariable UUID id) {
		return restauranteService.GetCozinhaById(id);
	}

	@GetMapping("/cozinhas/{nome}")
	public CozinhaEntity CozinhaByNome(@PathVariable String nome) {
		return restauranteService.GetCozinhaByNome(nome);
	}

	@DeleteMapping("/cozinha/{id}")
	public ResponseEntity<Void> removerCozinha(@PathVariable UUID id) {
		restauranteService.RemoverCozinha(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/cozinha/novo")
	public ResponseEntity<CozinhaEntity> adicionarCozinha(@RequestBody @Valid CozinhaInputDto dto) {
		CozinhaEntity entity = cozinhaMapper.toEntity(dto);
		return restauranteService.AdicionarCozinha(entity);
	}

	@GetMapping("/restaurantes")
	public List<RestauranteEntity> listarRestaurantes() {
		return restauranteService.GetRestaurantes();
	}

	@GetMapping("/restaurantes/pagamentos/{id}")
	public FormaPagamentoEntity getFormaPg(@PathVariable UUID id) {
		return serviceProjeto.getFormaPg(id);
	}

	@GetMapping("/restaurantes/{id}")
	public RestauranteEntity RestauranteById(@PathVariable UUID id) {
		return restauranteService.GetRestaurante(id);
	}

	@PostMapping("/restaurantes/novo")
	public ResponseEntity<?> CriarRestaurante(@RequestBody @Valid RestauranteInputDto dto) {
		try {
			RestauranteEntity entity = restauranteMapper.toEntity(dto);
			entity.setCozinha(filtroCozinha(dto.getCozinhaId()));
			entity.setFormaPagamento(getFormaPg(dto.getFormaPagamentoId()));
			RestauranteEntity novoRestaurante = restauranteService.AdicionarRestaurante(entity);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@PostMapping("/produtos/novo")
	public ResponseEntity<?> CadastroProduto(@RequestBody @Valid ProdutoInputDto dto) {

		try {
			ProdutoEntity entity = produtoMapper.toEntity(dto);
			entity.setAtivo(true);
			ProdutoEntity novo = restauranteService.adicionarProduto(entity);
			return ResponseEntity.status(HttpStatus.CREATED).body(novo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

}
