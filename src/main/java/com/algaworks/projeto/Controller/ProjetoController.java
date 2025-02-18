package com.algaworks.projeto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.projeto.Service.AtivacaoClienteService;
import com.algaworks.projeto.model.Cliente;

//responsavel por receber requisiçoes web 

@Controller
public class ProjetoController {

	private AtivacaoClienteService ativacaoCliente;

	public ProjetoController(AtivacaoClienteService ativacaoCliente) {
		this.ativacaoCliente = ativacaoCliente;
	}

	@GetMapping("/teste")
	@ResponseBody
	public String testerson() {
		Cliente jota = new Cliente("Jota","@gmail.com","6996969");
		ativacaoCliente.Ativar(jota);
		return "teste";
	}
}


