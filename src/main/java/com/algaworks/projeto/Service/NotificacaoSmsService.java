package com.algaworks.projeto.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.Service.Interfaces.NotificadorInterface;
import com.algaworks.projeto.model.Cliente;
@Profile("dev")
@Qualifier("sms")
@Component
public class NotificacaoSmsService implements NotificadorInterface {

	@Override
	public void enviar(Cliente cliente, String texto) {

		System.out.printf("Notificando %s pelo SMS %s : %s", cliente.getNome(), cliente.getTelefone(), texto);
	}

}
