package com.example.bancopan.exceptions;

public class InvalidZipCodeException extends RuntimeException {

    public InvalidZipCodeException() {}

    public InvalidZipCodeException(Throwable cause) {super(cause);}

    public InvalidZipCodeException(String message) {
        super(message);
    }

    public InvalidZipCodeException(String message, Throwable cause) {
        super(message, cause);
    }

}