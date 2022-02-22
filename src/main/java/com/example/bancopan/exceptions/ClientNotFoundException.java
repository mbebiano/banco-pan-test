package com.example.bancopan.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {}

    public ClientNotFoundException(Throwable cause) {super(cause);}

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}