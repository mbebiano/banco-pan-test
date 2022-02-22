package com.example.bancopan.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {}

    public AddressNotFoundException(Throwable cause) {super(cause);}

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}