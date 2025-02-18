package com.algaworks.projeto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.Service.Interfaces.NotificadorInterface;
import com.algaworks.projeto.model.Cliente;


@Qualifier("email")
@Component
public class NotificacaoEmailService implements NotificadorInterface {

	@Autowired
	private NotificadorProperties properties;

	@Override
	public void enviar(Cliente cliente, String texto) {

		System.out.println(properties.getHostServidor());
		System.out.println(properties.getPortaServidor());

		System.out.printf("Notificando %s pelo email %s : %s", cliente.getNome(), cliente.getEmail(), texto);
	}

}
