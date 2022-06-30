package com.augusto.example.augustin.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ContaException extends RuntimeException {
    public ContaException() {
        super();
    }

    public ContaException(String message) {
        super(message);
    }
}
