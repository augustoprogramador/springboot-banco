package com.augusto.example.augustin.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.example.augustin.Exceptions.ContaException;
import com.augusto.example.augustin.model.Conta;
import com.augusto.example.augustin.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    // retorno uma lista das contas cadastradas para o Controlador ContaController
    public List<Conta> listarContas() {
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }

    public Conta buscarConta(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isPresent()) {
            return conta.get();
        }
        return null;
    }

    public Conta Inserir(Conta conta) {
        conta = contaRepository.save(conta);
        return conta;
    }

    public Conta Atualizar(Conta conta) {
        Optional<Conta> user = contaRepository.findById(conta.getId());

        if (user.isPresent()) {
            Conta novaConta = user.get();
            novaConta.setNome(conta.getNome());
            novaConta.setDinheiro(conta.getDinheiro());

            novaConta = contaRepository.save(novaConta);
            return novaConta;

        } else {
            throw new ContaException("Conta não existe");
        }
    }
}
