package com.example.bancopan.converter;

import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.ClientResponse;
import com.example.bancopan.dto.ClientDTO;
import org.junit.Before;
import org.junit.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.ClientDTOFixture.CLIENT_DTO;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ClientDTOToClientResponseConverterTest extends BaseTest {

    private ClientDTOToClientResponseConverter converter;

    @Before
    public void before() {
        this.converter = new ClientDTOToClientResponseConverter();
    }

    @Test
    public void shouldClientDTOToClientResponse(){

        ClientDTO clientDTO = from(ClientDTO.class).gimme(CLIENT_DTO);

        ClientResponse response = converter.apply(clientDTO);

        assertThat(clientDTO, notNullValue());
        assertEquals(clientDTO.getFirstName(), response.getFirstName());
        assertEquals(clientDTO.getLastName(), response.getLastName());
        assertEquals(clientDTO.getEmail(), response.getEmail());
        assertEquals(clientDTO.getAddressDTO(), response.getAddress());

    }

    @Test
    public void shouldValidateNull(){

        ClientResponse response = converter.apply(null);

        assertNull(response);
    }

}