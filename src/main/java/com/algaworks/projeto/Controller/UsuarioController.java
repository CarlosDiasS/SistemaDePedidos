package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.projeto.domain.service.ServiceProjeto;
import com.algaworks.projeto.model.entity.FormaPagamentoEntity;
import com.algaworks.projeto.model.entity.UsuarioEntity;

import Mappers.UsuarioMapper;
import dto.ComboBoxUsuarioDto;
import dto.UsuarioInputDto;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private ServiceProjeto serviceProjeto;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@GetMapping("/usuarios")
	public List<UsuarioEntity> GetUsuarios() {
		return serviceProjeto.GetUsuarios();
	}

	@PostMapping("/usuarios/novo")
	public ResponseEntity<UsuarioEntity> CriarUsuario(@RequestBody UsuarioInputDto dto) {
		UsuarioEntity object = usuarioMapper.toEntity(dto);
		return serviceProjeto.CadastroUsuario(object);
	}

	@DeleteMapping("usuarios/{id}")
	public void DeleteById(@PathVariable UUID id) {
		serviceProjeto.DeleteById(id);
	}

	@GetMapping("/usuarios/senha")
	public Boolean VerificarSenha(@RequestBody @Valid ComboBoxUsuarioDto dto) {
		return serviceProjeto.VerificarHash(dto.getSenha(), dto.getId());
	}
	
	@PostMapping("/forma-pagamento/novo/{pg}")
	public ResponseEntity<FormaPagamentoEntity> CriarFormaPg(@PathVariable String pg ){
		return serviceProjeto.CadastrarFormaPg(pg);
		
	}
	
	

}
