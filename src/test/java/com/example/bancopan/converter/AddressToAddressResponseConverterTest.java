package com.example.bancopan.converter;

import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.enums.State;
import com.example.bancopan.dto.AddressDTO;
import org.junit.Before;
import org.junit.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.AddressDTOFixture.ADDRESS_DTO;
import static com.example.bancopan.fixture.AddressResponseFixture.ADDRESS_RESPONSE;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class AddressToAddressResponseConverterTest extends BaseTest {

    private AddressToAddressResponseConverter converter;

    @Before
    public void before() {
        this.converter = new AddressToAddressResponseConverter();
    }

    @Test
    public void shouldAddressToAddressResponse(){

        AddressDTO addressDTO = from(AddressDTO.class).gimme(ADDRESS_DTO);

        AddressResponse addressResponse = from(AddressResponse.class).gimme(ADDRESS_RESPONSE);

        Address adress = converter.apply(addressDTO, addressResponse);

        assertThat(adress, notNullValue());
        assertEquals(adress.getCity(), addressResponse.getCity());
        assertEquals(adress.getNumber(), addressDTO.getNumber());
        assertEquals(adress.getState(), State.getEnum(addressResponse.getState()));
        assertEquals(adress.getStreet(), addressResponse.getStreet());
        assertEquals(adress.getZipcode(), addressResponse.getZipCode());

    }

    @Test
    public void shouldValidateNull(){

        Address adress = converter.apply(null, null);

        assertNull(adress);
    }

}