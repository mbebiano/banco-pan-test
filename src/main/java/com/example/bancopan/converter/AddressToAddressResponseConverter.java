package com.example.bancopan.converter;

import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.enums.State;
import com.example.bancopan.dto.AddressDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

import static java.util.Objects.isNull;

@Component
public class AddressToAddressResponseConverter implements BiFunction<AddressDTO, AddressResponse, Address> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressToAddressResponseConverter.class);

    @Override
    public Address apply(AddressDTO addressDTO, AddressResponse response) {

        LOGGER.info("stage=init method=AddressToAddressResponseConverter.apply response={} addressDTO={}",
                response, addressDTO);

        Address address = new Address();

        if (isNull(response) || isNull(addressDTO)){
            return null;
        }

        address.withCity(response.getCity())
                .withNumber(addressDTO.getNumber())
                .withState(State.getEnum(response.getState()))
                .withStreet(response.getStreet())
                .withZipCode(response.getZipCode());


        LOGGER.info("stage=end method=AddressToAddressResponseConverter.apply address={}",
                address);

        return address;
    }

}