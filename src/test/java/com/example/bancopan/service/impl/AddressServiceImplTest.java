package com.example.bancopan.service.impl;

import com.example.bancopan.BaseTest;
import com.example.bancopan.connector.api.ViaCepAPI;
import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.exceptions.AddressNotFoundException;
import com.example.bancopan.fixture.AddressResponseFixture;
import com.example.bancopan.repository.AddressRepository;
import com.example.bancopan.validations.validator.ZipCodeValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static br.com.six2six.fixturefactory.Fixture.from;
import static java.math.BigInteger.ONE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AddressServiceImplTest extends BaseTest {

    @Mock private AddressRepository repository;
    @Mock private ViaCepAPI viaCepService;
    @Mock private ZipCodeValidator zipCodeValidator;

    @InjectMocks
    private AddressServiceImpl service;

    @Test
    public void shouldSucessToFindAddressByZipCode() {

        AddressResponse addressResponse = from(AddressResponse.class).gimme(AddressResponseFixture.ADDRESS_RESPONSE);

        when(viaCepService.findByZipCode(addressResponse.getZipCode())).thenReturn(addressResponse);

        AddressResponse addressResponseReturn = service.findByZipCode(addressResponse.getZipCode());

        Assert.assertNotNull(addressResponseReturn);
        Assert.assertEquals(addressResponse.getZipCode(), addressResponseReturn.getZipCode());
        Assert.assertEquals(addressResponse.getCity(), addressResponseReturn.getCity());
        Assert.assertEquals(addressResponse.getComplement(), addressResponseReturn.getComplement());
        Assert.assertEquals(addressResponse.getDistrict(), addressResponseReturn.getDistrict());
        Assert.assertEquals(addressResponse.getState(), addressResponseReturn.getState());
        Assert.assertEquals(addressResponse.getStreet(), addressResponseReturn.getStreet());
        verify(this.viaCepService, times(ONE.intValue())).findByZipCode(anyString());
    }

    @Test(expected = AddressNotFoundException.class)
    public void shouldFailedToFindAddressByZipCodeNotFound() {

        AddressResponse addressResponse = from(AddressResponse.class).gimme(AddressResponseFixture.ADDRESS_RESPONSE);

        when(viaCepService.findByZipCode(addressResponse.getZipCode())).thenReturn(null);

        AddressResponse addressResponseReturn = service.findByZipCode(addressResponse.getZipCode());

        Assert.assertNull(addressResponseReturn);
        verify(this.viaCepService, times(ONE.intValue())).findByZipCode(anyString());
    }

}