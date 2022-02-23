package com.example.bancopan.converter;

import com.example.bancopan.BaseTest;
import com.example.bancopan.domain.Client;
import com.example.bancopan.dto.ClientDTO;
import org.junit.Before;
import org.junit.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.ClientFixture.CLIENT;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ClientToClientDTOConverterTest extends BaseTest {

    private ClientToClientDTOConverter converter;

    @Before
    public void before() {
        this.converter = new ClientToClientDTOConverter();
    }

    @Test
    public void shouldClientToClientDTOConverter() {

        Client client = from(Client.class).gimme(CLIENT);

        ClientDTO clientDTO = converter.apply(client);

        assertThat(clientDTO, notNullValue());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getDocument(), clientDTO.getDocument());
        assertEquals(client.getEmail(), clientDTO.getEmail());
        assertEquals(client.getAddress().getZipcode(), clientDTO.getAddressDTO().getZipcode());
        assertEquals(client.getAddress().getStreet(), clientDTO.getAddressDTO().getStreet());
        assertEquals(client.getAddress().getCity(), clientDTO.getAddressDTO().getCity());
        assertEquals(client.getAddress().getState(), clientDTO.getAddressDTO().getState());

    }

    @Test
    public void shouldValidateNull() {

        ClientDTO clientDTO = converter.apply(null);

        assertNull(clientDTO);
    }

}