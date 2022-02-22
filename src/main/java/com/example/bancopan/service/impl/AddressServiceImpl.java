package com.example.bancopan.service.impl;

import com.example.bancopan.connector.api.ViaCepAPI;
import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.exceptions.AddressNotFoundException;
import com.example.bancopan.repository.AddressRepository;
import com.example.bancopan.service.AddressService;
import com.example.bancopan.validations.validator.ZipCodeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final AddressRepository repository;

    private final ViaCepAPI viaCepService;

    private final ZipCodeValidator zipCodeValidator;

    public AddressServiceImpl(AddressRepository repository,
                              ViaCepAPI viaCepService,
                              ZipCodeValidator zipCodeValidator){

        this.repository = repository;
        this.viaCepService = viaCepService;
        this.zipCodeValidator = zipCodeValidator;
    }

    @Override
    public AddressResponse findByZipCode(String zipCode) {

        LOGGER.info("stage=init method=AddressServiceImpl.findByZipCode "
                + "Message=Find address by zipCode={}", zipCode);

        zipCodeValidator.isValidatedZipCode(zipCode);

        AddressResponse addressResponse = this.viaCepService.findByZipCode(zipCode);

        if (isNull(addressResponse)||isNull(addressResponse.getZipCode())){
            LOGGER.error("stage=end method=AddressServiceImpl.findByZipCode message=Address not found zipCode={}", zipCode);
            throw new AddressNotFoundException("Address not found");
        }

        LOGGER.info("stage=init method=AddressServiceImpl.findByZipCode "
                + "Message=Address Response={}", addressResponse);

        return addressResponse;
    }

}