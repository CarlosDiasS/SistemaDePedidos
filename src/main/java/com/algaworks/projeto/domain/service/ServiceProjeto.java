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

	List<EstadoEntity> GetEstados();

	List<UsuarioEntity> GetUsuarios();

	EstadoEntity GetEstadoByNome(String nome);

	Optional<CidadeEntity> FindCidadesByEstado(UUID estadoId);

	String CodificacaoSha256(String input);

	ResponseEntity<UsuarioEntity> CadastroUsuario(UsuarioEntity usuario);

	UsuarioEntity GetUsuarioByName(String nome);

	void DeleteById(UUID id);

	FormaPagamentoEntity getFormaPg(UUID id);
	
	public Boolean VerificarHash(String input, UUID id);

}