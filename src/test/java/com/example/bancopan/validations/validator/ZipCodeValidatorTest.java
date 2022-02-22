package com.example.bancopan.validations.validator;

import com.example.bancopan.BaseTest;
import com.example.bancopan.exceptions.InvalidZipCodeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZipCodeValidatorTest extends BaseTest {

    private ZipCodeValidator zipCodeValidator;

    @Before
    public void before() {
        this.zipCodeValidator = new ZipCodeValidator();
    }

    @Test
    public void shouldIsValidatedCPF(){

        String zipCode = "36047100";

        String zipCodeReturn = zipCodeValidator.isValidatedZipCode(zipCode);

        assertNotNull(zipCodeReturn);
        assertEquals(zipCode, zipCodeReturn);

    }

    @Test(expected = InvalidZipCodeException.class)
    public void shouldIsValidatedCPFWithNotValidCPF(){

        String zipCodeReturn = zipCodeValidator.isValidatedZipCode(null);

        assertNull(zipCodeReturn);
    }

}