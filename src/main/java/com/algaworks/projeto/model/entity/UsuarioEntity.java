package com.algaworks.projeto.model.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@Email
	@NotBlank
	@Column(nullable = false)
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String senha;

	@Column
	@CreationTimestamp
	private LocalDateTime dataCadastro;

	@ManyToMany
	@JoinTable(name = "grupo")
	private Set<GrupoEntity> grupo;

}
