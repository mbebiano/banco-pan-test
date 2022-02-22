package com.example.bancopan.controller.request;

import javax.validation.constraints.NotBlank;

public class ClientChangeAddressRequest {

    @NotBlank(message = "You must fill in the document")
    private String document;

    @NotBlank(message = "You must fill in the adress")
    private AddressChangeRequest address;


    public String getDocument() {
        return document;
    }

    public ClientChangeAddressRequest withDocument(String document) {
        this.document = document;
        return this;
    }

    public AddressChangeRequest getAddress() {
        return address;
    }

    public ClientChangeAddressRequest withAddress(AddressChangeRequest address) {
        this.address = address;
        return this;
    }

}