package com.algaworks.projeto.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.domain.service.ServiceProjeto;
import com.algaworks.projeto.model.entity.CidadeEntity;
import com.algaworks.projeto.model.entity.EstadoEntity;

@RestController
public class EstadoController {
	
	@Autowired
	private ServiceProjeto serviceProjeto;

	@GetMapping("/estados")
	public List<EstadoEntity> GetEstados() {
		return serviceProjeto.GetEstados();
	}

	@GetMapping("/estados/{id}")
	public Optional<CidadeEntity> GetCidadesPorEstado(@RequestParam UUID estadoId) {
		return serviceProjeto.FindCidadesByEstado(estadoId);
	}
	
	
}
