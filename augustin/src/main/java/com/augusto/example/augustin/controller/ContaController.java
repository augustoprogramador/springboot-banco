package com.augusto.example.augustin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.augusto.example.augustin.Services.ContaService;
import com.augusto.example.augustin.model.Conta;

@Controller

public class ContaController {

	@Autowired
	ContaService contaService;

	// definição da rota principal
	@RequestMapping(value = "/")
	public String index(Conta conta) {
		return "login";
	}

	// definição da rota de consulta
	@RequestMapping("/consultarConta")
	public String lista(Conta conta, Model model) throws Exception {
		try {
			model.addAttribute("contas", contaService.listarContas());
			// chamando a view consultar
			return "consultar";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// definição da rota de cadastro
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String inserirConta(Conta conta) throws Exception {
		try {
			contaService.Inserir(conta);
			return "principal";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
