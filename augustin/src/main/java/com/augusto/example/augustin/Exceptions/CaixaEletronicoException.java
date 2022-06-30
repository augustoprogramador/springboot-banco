package com.augusto.example.augustin.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CaixaEletronicoException extends RuntimeException {
    public CaixaEletronicoException() {
        super();
    }

    public CaixaEletronicoException(String mensagem) {
        super(mensagem);
    }
}
