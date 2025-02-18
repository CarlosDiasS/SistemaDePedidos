package com.algaworks.projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.Service.CreateCozinhaService;
import com.algaworks.projeto.model.entity.CozinhaEntity;

@RestController
@RequestMapping(value = "/create")
public class ControllerAddCozinha {

	@Autowired
	private CreateCozinhaService cozinhaService;

	@PostMapping
	public ResponseEntity<CozinhaEntity> adicionarCozinha(@RequestBody CozinhaEntity cozinha) {

		if (cozinha == null || cozinha.getNome() == null) {
			return ResponseEntity.badRequest().build();
		}

		CozinhaEntity novaCozinha = cozinhaService.createCozinha(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCozinha);
	}

}
