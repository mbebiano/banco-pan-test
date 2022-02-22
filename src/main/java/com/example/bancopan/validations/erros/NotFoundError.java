package com.example.bancopan.validations.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundError extends Error {

    private static final long serialVersionUID = 5948855699361346712L;

    public NotFoundError(String message, Integer status, String path) {
        super(message, status, path);
    }

}
