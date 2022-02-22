package com.example.bancopan.validations.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestError extends Error {

    private static final long serialVersionUID = 5948855699361346712L;

    public BadRequestError(String message, Integer status, String path) {
        super(message, status, path);
    }

}

