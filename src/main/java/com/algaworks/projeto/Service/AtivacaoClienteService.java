package com.algaworks.projeto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.algaworks.projeto.model.Cliente;

//@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	// private List<NotificadorInterface> notificadores;
	// @Autowired
	// private NotificadorInterface notificador;

	// @PostConstruct
	public void init() {
		System.out.println("Init");
	}

	// @PreDestroy
	public void destroy() {
		System.out.println("Destroy");
	}

	public void Ativar(Cliente cliente) {

		cliente.Ativar();

		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

		// for (NotificadorInterface notificador : notificadores) {
		// notificador.enviar(cliente, "cadastro ativo" + "\n");
		// }

		// notificador.enviar(cliente, "Cadastro Ativo");

	}

}
