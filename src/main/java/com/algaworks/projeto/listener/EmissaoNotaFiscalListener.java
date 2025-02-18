package com.algaworks.projeto.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.Service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalListener {

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para: " + event.getCliente().getNome());
	}

}
