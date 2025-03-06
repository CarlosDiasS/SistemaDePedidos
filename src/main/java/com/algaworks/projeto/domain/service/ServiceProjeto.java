package com.algaworks.projeto.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.model.entity.CidadeEntity;
import com.algaworks.projeto.model.entity.EstadoEntity;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.UsuarioEntity;
import com.algaworks.projeto.model.repository.CidadeRepository;
import com.algaworks.projeto.model.repository.EstadoRepository;
import com.algaworks.projeto.model.repository.FormaPagamentoRepository;
import com.algaworks.projeto.model.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceProjeto {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	public List<EstadoEntity> GetEstados() {
		return estadoRepository.findAll();
	}

	public List<UsuarioEntity> GetUsuarios() {
		return usuarioRepository.findAll();
	}

	public EstadoEntity GetEstadoByNome(String nome) {
		return estadoRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("Estado nao encontrado."));
	}

	public Optional<CidadeEntity> FindCidadesByEstado(UUID estadoId) {
		Optional<CidadeEntity> aux = cidadeRepository.findByEstadoId(estadoId);
		if (aux.isEmpty()) {
			throw new EntityNotFoundException("Nenhuma cidade encontrada para o estado.");
		}
		return aux;
	}

	public ResponseEntity<UsuarioEntity> CadastroUsuario(UsuarioEntity usuario) {
		UsuarioEntity aux = usuarioRepository.saveAndFlush(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(aux);
		// add tratativa para senha

	}

	public UsuarioEntity GetUsuarioByName(String nome) {
		return usuarioRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
	}

	public void DeleteById(UUID id) {
		usuarioRepository.deleteById(id);
	}

	public FormaPagamentoEntity getFormaPg(UUID id) {
		return formaPagamentoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Forma de pagamento nao encontrado"));
	}

	// imp autenticacao

}
