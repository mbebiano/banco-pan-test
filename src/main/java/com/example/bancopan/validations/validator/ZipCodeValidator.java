package com.example.bancopan.validations.validator;

import com.example.bancopan.exceptions.InvalidZipCodeException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ZipCodeValidator {

    public String isValidatedZipCode(String zipCode){
        if (!isValidZipCode(zipCode)){
            throw new InvalidZipCodeException("Invalid zip code");
        }
        return zipCode;
    }

    private static boolean isValidZipCode(String zipCode) {
        return (!Objects.isNull(zipCode)) && (zipCode.length() == 8)
                && zipCode.matches("\\d{8}");
    }

}