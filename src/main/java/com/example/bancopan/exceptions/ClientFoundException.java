package com.example.bancopan.exceptions;

public class ClientFoundException extends RuntimeException {

    public ClientFoundException() {}

    public ClientFoundException(Throwable cause) {super(cause);}

    public ClientFoundException(String message) {
        super(message);
    }

    public ClientFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}