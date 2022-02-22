package com.example.bancopan.validations.erros;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties({"cause", "stackTrace", "suppressed", "localizedMessage"})
public abstract class Error extends RuntimeException {

    private static final long serialVersionUID = 1851097614447067609L;

    private final LocalDateTime timestamp;
    private final String message;
    private final Integer status;
    private final String path;

    public Error(String message, Integer status, String path) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

}

