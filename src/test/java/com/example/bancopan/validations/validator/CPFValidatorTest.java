package com.example.bancopan.validations.validator;

import com.example.bancopan.BaseTest;
import com.example.bancopan.exceptions.CPFNotValidException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CPFValidatorTest extends BaseTest {

    private CPFValidator cpfValidator;

    @Before
    public void before() {
        this.cpfValidator = new CPFValidator();
    }

    @Test
    public void shouldIsValidatedCPF(){

        String document = "53313289037";

        String documentReturn = cpfValidator.isValidatedCPF(document);

        assertNotNull(documentReturn);
        assertEquals(document, documentReturn);

    }

    @Test(expected = CPFNotValidException.class)
    public void shouldIsValidatedCPFWithNotValidCPF(){

        String documentReturn = cpfValidator.isValidatedCPF(null);

        assertNull(documentReturn);
    }

}