package com.algaworks.projeto.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.Service.ClienteAtivadoEvent;
import com.algaworks.projeto.Service.NotificacaoEmailService;

@Component
public class NotificacaoServiceListener {

	@Autowired
	private NotificacaoEmailService notificador;

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.enviar(event.getCliente(), "Cadastro ativo");
	}

}
