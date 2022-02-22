package com.example.bancopan.connector.api;

import com.example.bancopan.controller.response.AddressResponse;
import feign.Param;
import feign.RequestLine;

public interface ViaCepAPI {

    @RequestLine("GET /{zipCode}/json")
    AddressResponse findByZipCode(@Param("zipCode") String zipCode);
}
