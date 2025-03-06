package com.algaworks.projeto.model.entity;

import java.util.UUID;

import Utils.EnumCategoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name= "cozinha")
public class CozinhaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotBlank
	@Column
	private String nome;
	
	@NotBlank
	private EnumCategoria categoria;
}
