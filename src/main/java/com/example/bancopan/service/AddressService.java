package com.example.bancopan.service;

import com.example.bancopan.controller.response.AddressResponse;

public interface AddressService {

    AddressResponse findByZipCode(String zipCode);

}