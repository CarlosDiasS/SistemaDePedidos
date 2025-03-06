package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.algaworks.projeto.model.entity.CozinhaEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.ProdutoEntity;
import com.algaworks.projeto.model.entity.RestauranteEntity;

public interface RestauranteService {

	List<CozinhaEntity> GetCozinhas();

	List<ProdutoEntity> GetProdutos();

	List<RestauranteEntity> GetRestaurantes();

	RestauranteEntity GetRestaurante(UUID id);

	List<FormaPagamentoEntity> GetFormasPg();

	ResponseEntity<FormaPagamentoEntity> CadastrarFormaPg(FormaPagamentoEntity formaPg);

	ResponseEntity<CozinhaEntity> AdicionarCozinha(CozinhaEntity cozinhaEntity);

	/*
	 * Verifica se a o cozinha e forma pagamento enviados na requisição sao validos
	 * Logo apos, processa a transação
	 */
	RestauranteEntity AdicionarRestaurante(RestauranteEntity entity) throws Exception;

	CozinhaEntity GetCozinhaById(UUID id);

	CozinhaEntity GetCozinhaByNome(String nome);

	void RemoverCozinha(UUID id);

	ProdutoEntity adicionarProduto(ProdutoEntity entity);

}