package com.algaworks.projeto.Service.Interfaces;

import com.algaworks.projeto.model.Cliente;

public interface NotificadorInterface {

	void enviar(Cliente cliente, String texto);

}