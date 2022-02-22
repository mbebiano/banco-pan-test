package com.example.bancopan.controller.response;

import com.example.bancopan.dto.AddressDTO;

public class ClientResponse {

    private String document;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDTO address;


    public String getDocument() {
        return document;
    }

    public ClientResponse withDocument(String document) {
        this.document = document;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ClientResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public ClientResponse withAddress(AddressDTO address) {
        this.address = address;
        return this;
    }
}