package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.ProdutoEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;
import com.algaworks.projeto.model.repository.CozinhaRepository;
import com.algaworks.projeto.model.repository.FormaPagamentoRepository;
import com.algaworks.projeto.model.repository.ProdutoRepository;
import com.algaworks.projeto.model.repository.RestauranteRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RestauranteService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<CozinhaEntity> GetCozinhas() {
		return cozinhaRepository.findAll();

	}

	public List<ProdutoEntity> GetProdutos() {
		return produtoRepository.findAll();
	}

	public List<RestauranteEntity> GetRestaurantes() {
		return restauranteRepository.findAll();

	}

	public RestauranteEntity GetRestaurante(UUID id) {
		return restauranteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado."));
	}

	public List<FormaPagamentoEntity> GetFormasPg() {
		return formaPagamentoRepository.findAll();
	}

	@Transactional
	public ResponseEntity<FormaPagamentoEntity> CadastrarFormaPg(FormaPagamentoEntity formaPg) {
		FormaPagamentoEntity aux = formaPagamentoRepository.saveAndFlush(formaPg);
		return ResponseEntity.status(HttpStatus.CREATED).body(aux);
	}

	@Transactional
	public ResponseEntity<CozinhaEntity> AdicionarCozinha(CozinhaEntity cozinhaEntity) {
		CozinhaEntity novaCozinha = cozinhaRepository.saveAndFlush(cozinhaEntity);
		System.err.println("Cozinha adicionada: " + novaCozinha.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCozinha);

	}

	/*
	 * Verifica se a o cozinha e forma pagamento enviados na requisição sao validos
	 * Logo apos, processa a transação
	 */
	@Transactional
	public RestauranteEntity AdicionarRestaurante(RestauranteEntity entity) throws Exception {
		CozinhaEntity cozinhaAux = entity.getCozinha();
		if (cozinhaAux == null || GetCozinhaById(cozinhaAux.getId()) == null) {
			throw new Exception("Cozinha inexistente");
		}
		return restauranteRepository.saveAndFlush(entity);
	}

	public CozinhaEntity GetCozinhaById(UUID id) {
		return cozinhaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("cozinha não encontrada"));
	}

	public CozinhaEntity GetCozinhaByNome(String nome) {
		return cozinhaRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("cozinha não encontrada."));
	}

	public void RemoverCozinha(UUID id) {
		cozinhaRepository.deleteById(id);
	}

	@Transactional
	public ProdutoEntity adicionarProduto(ProdutoEntity entity) {
		return produtoRepository.saveAndFlush(entity);
	}

}
