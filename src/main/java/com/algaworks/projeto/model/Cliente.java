package com.algaworks.projeto.model;

public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private Boolean ativo;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void Ativar() {
		this.ativo = true;
	}

	public String getTelefone() {
		return telefone;
	}
	
}
