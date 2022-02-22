package com.example.bancopan.controller.response;

import com.example.bancopan.dto.AddressDTO;

public class ClientChangedAddressResponse {

    private AddressDTO address;

    public AddressDTO getAddress() {
        return address;
    }

    public ClientChangedAddressResponse withAddress(AddressDTO address) {
        this.address = address;
        return this;
    }
}