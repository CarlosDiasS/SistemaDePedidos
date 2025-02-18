package com.algaworks.projeto.Service;

import org.springframework.stereotype.Component;

import com.algaworks.projeto.Service.Interfaces.NotificadorInterface;
import com.algaworks.projeto.model.Cliente;

//@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements NotificadorInterface {

	@Override
	public void enviar(Cliente cliente, String texto) {

		System.out.printf("Notificando %s pelo SMS %s : %s", cliente.getNome(), cliente.getTelefone(), texto);
	}

}
