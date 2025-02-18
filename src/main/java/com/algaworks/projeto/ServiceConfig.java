package com.algaworks.projeto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.projeto.Service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    AtivacaoClienteService ativacaoCliente() {
		return new AtivacaoClienteService();
	}
	
}
