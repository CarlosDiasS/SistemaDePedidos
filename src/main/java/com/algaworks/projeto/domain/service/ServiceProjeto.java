package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.algaworks.projeto.model.entity.CidadeEntity;
import com.algaworks.projeto.model.entity.EstadoEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.UsuarioEntity;

public interface ServiceProjeto {

	List<EstadoEntity> getEstados();

	List<UsuarioEntity> getUsuarios();

	EstadoEntity getEstadoByNome(String nome);

	Optional<CidadeEntity> findCidadesByEstado(UUID estadoId);

	String codificacaoSha256(String input);

	ResponseEntity<UsuarioEntity> cadastroUsuario(UsuarioEntity usuario);

	UsuarioEntity getUsuarioByName(String nome);

	void deleteById(UUID id);

	FormaPagamentoEntity getFormaPg(UUID id);

	public Boolean verificarHash(String input, UUID id);

	ResponseEntity<FormaPagamentoEntity> cadastrarFormaPg(String pg);

}