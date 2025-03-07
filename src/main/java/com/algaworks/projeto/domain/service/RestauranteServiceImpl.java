package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.Optional;
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
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<CozinhaEntity> GetCozinhas() {
		return cozinhaRepository.findAll();

	}

	@Override
	public List<ProdutoEntity> GetProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public List<RestauranteEntity> GetRestaurantes() {
		return restauranteRepository.findAll();

	}

	@Override
	public RestauranteEntity GetRestaurante(UUID id) {
		return restauranteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado."));
	}

	@Override
	public List<FormaPagamentoEntity> GetFormasPg() {
		return formaPagamentoRepository.findAll();
	}

	@Override
	@Transactional
	public ResponseEntity<FormaPagamentoEntity> CadastrarFormaPg(FormaPagamentoEntity formaPg) {
		FormaPagamentoEntity aux = formaPagamentoRepository.saveAndFlush(formaPg);
		return ResponseEntity.status(HttpStatus.CREATED).body(aux);
	}

	@Override
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
	@Override
	@Transactional
	public RestauranteEntity AdicionarRestaurante(RestauranteEntity entity) throws Exception {
		if (cozinhaRepository.findById(entity.getCozinha().getId()) == null) {
			throw new Exception("Cozinha inexistente");
		}
		if (formaPagamentoRepository.findById(entity.getFormaPagamento().getId()) == null) {
			throw new Exception("Forma de pagamento inexistente");
		}
		return restauranteRepository.saveAndFlush(entity);
	}

	@Override
	public CozinhaEntity GetCozinhaById(UUID id) {
		return cozinhaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("cozinha não encontrada"));
	}

	@Override
	public CozinhaEntity GetCozinhaByNome(String nome) {
		return cozinhaRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("cozinha não encontrada."));
	}

	@Override
	public void RemoverCozinha(UUID id) {
		cozinhaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public ProdutoEntity adicionarProduto(ProdutoEntity entity) {
		return produtoRepository.saveAndFlush(entity);
	}

	@Override
	public List<ProdutoEntity> ProdutosByRestaurante(UUID restauranteId) {
		try {
			Optional<RestauranteEntity> restauranteOptional = restauranteRepository.findById(restauranteId);

			if (!restauranteOptional.isPresent()) {
				throw new Exception("Restaurante inexistente");
			}
			return produtoRepository.findByRestaurante(restauranteOptional.get());

		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar produtos do restaurante: " + e.getMessage(), e);
		}
	}

}
