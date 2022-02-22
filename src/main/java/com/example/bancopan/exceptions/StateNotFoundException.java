package com.example.bancopan.exceptions;

public class StateNotFoundException extends RuntimeException {

    public StateNotFoundException() {}

    public StateNotFoundException(Throwable cause) {super(cause);}

    public StateNotFoundException(String message) {
        super(message);
    }

    public StateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}