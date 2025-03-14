package com.algaworks.projeto.domain.service;

import java.security.MessageDigest;
import java.util.HexFormat;
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
public class ServiceProjetoImpl implements ServiceProjeto {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Override
	public List<EstadoEntity> getEstados() {
		return estadoRepository.findAll();
	}

	@Override
	public List<UsuarioEntity> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public EstadoEntity getEstadoByNome(String nome) {
		return estadoRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("Estado nao encontrado."));
	}

	@Override
	public Optional<CidadeEntity> findCidadesByEstado(UUID estadoId) {
		Optional<CidadeEntity> aux = cidadeRepository.findByEstadoId(estadoId);
		if (aux.isEmpty()) {
			throw new EntityNotFoundException("Nenhuma cidade encontrada para o estado.");
		}
		return aux;
	}

	@Override
	public String codificacaoSha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes());
			return HexFormat.of().formatHex(hash);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao codificar a senha com SHA-256.", e);
		}
	}

	@Override
	public Boolean verificarHash(String input, UUID id) {
		String hashGerado = codificacaoSha256(input);
		UsuarioEntity user = usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));
		return hashGerado.equals(user.getSenha());
	}

	// estudar implementação de token, possibilitando o acesso a senha do banco

	@Override
	public ResponseEntity<UsuarioEntity> cadastroUsuario(UsuarioEntity usuario) {

		String password = usuario.getSenha();
		UsuarioEntity novo = new UsuarioEntity();
		novo.setSenha(codificacaoSha256(password));
		novo.setDataCadastro(usuario.getDataCadastro());
		novo.setEmail(usuario.getEmail());
		novo.setNome(usuario.getNome());
		novo.setGrupo(usuario.getGrupo());
		UsuarioEntity aux = usuarioRepository.saveAndFlush(novo);
		return ResponseEntity.status(HttpStatus.CREATED).body(aux);
	}

	@Override
	public UsuarioEntity getUsuarioByName(String nome) {
		return usuarioRepository.findByNome(nome)
				.orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
	}

	@Override
	public void deleteById(UUID id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public FormaPagamentoEntity getFormaPg(UUID id) {
		return formaPagamentoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Forma de pagamento nao encontrado"));
	}

	@Override
	public ResponseEntity<FormaPagamentoEntity> cadastrarFormaPg(String pg) {

		FormaPagamentoEntity aux = new FormaPagamentoEntity();
		aux.setDescricao(pg);
		formaPagamentoRepository.saveAndFlush(aux);
		return ResponseEntity.status(HttpStatus.CREATED).body(aux);
	}

	// imp autenticacao

}
