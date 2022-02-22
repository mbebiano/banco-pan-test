package com.example.bancopan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class ClientDTO {

    private String document;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDTO addressDTO;


    public String getDocument() {
        return document;
    }

    public ClientDTO withDocument(String document) {
        this.document = document;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ClientDTO withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientDTO withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientDTO withEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public ClientDTO withAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
        return this;
    }
}
