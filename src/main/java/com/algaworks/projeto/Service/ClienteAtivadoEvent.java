package com.algaworks.projeto.Service;

import com.algaworks.projeto.model.Cliente;

public class ClienteAtivadoEvent {

	private Cliente cliente;

	//construtor
	
	public ClienteAtivadoEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
