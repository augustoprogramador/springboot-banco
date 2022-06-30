package com.augusto.example.augustin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.augusto.example.augustin.Services.CaixaEletronicoService;
import com.augusto.example.augustin.Services.ContaService;
import com.augusto.example.augustin.model.Conta;

@Controller
public class CaixaEletronicoController {

    @Autowired
    CaixaEletronicoService caixaEletronicoService;

    @Autowired

    ContaService contaService;

    // definição da rota de deposito
    @RequestMapping(path = { "/teladeposito", "/teladeposito/{id}" })
    public String telaDeposito(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Conta conta = contaService.buscarConta(id.get());
            model.addAttribute("conta", conta);
        } else {
            model.addAttribute("conta", new Conta());
        }
        return "depositar";
    }

    // definição da rota de saque
    @RequestMapping(path = { "/telasaque", "/telasaque/{id}" })
    public String telaSaque(Model model, @PathVariable("id") Optional<Long> id) {
        Conta conta = contaService.buscarConta(id.get());
        model.addAttribute("conta", conta);
        return "saque";
    }

    // definição da rota de deposito
    @RequestMapping(path = "/deposito", method = RequestMethod.POST)
    public String depositarDinheiro(Conta conta, @RequestParam(value = "valor", required = false) String dinherio)
            throws Exception {
        try {
            caixaEletronicoService.depositarDinheiro(dinherio, conta);
            return "principal";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    // definição da rota de saque
    @RequestMapping(path = "/sacar", method = RequestMethod.POST)
    public String sacarDinheiro(Conta conta, @RequestParam(value = "valor", required = false) String dinherio)
            throws Exception {
        try {
            // chamo a função para sacar o dinheiro
            caixaEletronicoService.sacarDinheiro(dinherio, conta);
            return "principal";

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
