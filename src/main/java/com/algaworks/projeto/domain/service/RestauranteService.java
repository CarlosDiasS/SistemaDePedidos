package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.ProdutoEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;

public interface RestauranteService {

	List<CozinhaEntity> getCozinhas();

	List<ProdutoEntity> getProdutos();

	List<RestauranteEntity> getRestaurantes();

	RestauranteEntity getRestaurante(UUID id);

	List<FormaPagamentoEntity> getFormasPg();

	ResponseEntity<FormaPagamentoEntity> cadastrarFormaPg(FormaPagamentoEntity formaPg);

	ResponseEntity<CozinhaEntity> adicionarCozinha(CozinhaEntity cozinhaEntity);

	/*
	 * Verifica se a o cozinha e forma pagamento enviados na requisição sao validos
	 * Logo apos, processa a transação
	 */
	RestauranteEntity adicionarRestaurante(RestauranteEntity entity) throws Exception;

	CozinhaEntity getCozinhaById(UUID id);

	CozinhaEntity getCozinhaByNome(String nome);

	void removerCozinha(UUID id);

	ProdutoEntity adicionarProduto(ProdutoEntity entity);
	
	public List<ProdutoEntity> produtosByRestaurante(UUID restauranteid);

}