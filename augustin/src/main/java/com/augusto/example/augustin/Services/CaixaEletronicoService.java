package com.augusto.example.augustin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.example.augustin.model.Conta;

@Service
public class CaixaEletronicoService {
    @Autowired
    ContaService contaService;

    public void depositarDinheiro(String dinheiro, Conta conta) {

        // converto o valor que veio do formulário para inteiro
        int dinheiroInserido = Integer.parseInt(dinheiro);
        // adiciono ao montante trazido pela função getDinheiro()
        int dinheiroAtualizado = conta.getDinheiro() + dinheiroInserido;
        // coloco o dinheito na conta
        conta.setDinheiro(dinheiroAtualizado);
        // atualizo o banco
        contaService.Atualizar(conta);
    }

    public void sacarDinheiro(String dinheiro, Conta conta) {

        int dinheiroInserido = Integer.parseInt(dinheiro);
        int dinheiroAtualizado = conta.getDinheiro() - dinheiroInserido;

        conta.setDinheiro(dinheiroAtualizado);

        contaService.Atualizar(conta);
    }
}
