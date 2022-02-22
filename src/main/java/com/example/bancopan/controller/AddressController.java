package com.example.bancopan.controller;

import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping(value = "/{zipCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponse> getAddressByZipCode(@PathVariable(value = "zipCode") String zipCode) {

        LOGGER.info("stage=init method=AddressController.getAddressByCep zipCode={}", zipCode);

        AddressResponse response = this.service.findByZipCode(zipCode);

        LOGGER.info("stage=end method=AddressController.getAddressByCep response={}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}