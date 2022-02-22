package com.example.bancopan.exceptions;

public class CPFNotValidException extends RuntimeException {

    public CPFNotValidException() {}

    public CPFNotValidException(Throwable cause) {super(cause);}

    public CPFNotValidException(String message) {
        super(message);
    }

    public CPFNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

}