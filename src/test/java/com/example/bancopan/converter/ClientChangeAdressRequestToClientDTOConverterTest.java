package com.example.bancopan.converter;

import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.request.ClientChangeAddressRequest;
import com.example.bancopan.dto.ClientDTO;
import org.junit.Before;
import org.junit.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.ClientChangeAddressRequestFixture.CLIENT_CHANGE_ADDRESS_REQUEST;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ClientChangeAdressRequestToClientDTOConverterTest extends BaseTest {

    private ClientChangeAdressRequestToClientDTOConverter converter;

    @Before
    public void before() {
        this.converter = new ClientChangeAdressRequestToClientDTOConverter();
    }

    @Test
    public void shouldClientChangeAdressRequestToClientDTO(){

        ClientChangeAddressRequest clientChangeAddressRequest = from(ClientChangeAddressRequest.class).
                gimme(CLIENT_CHANGE_ADDRESS_REQUEST);

        ClientDTO clientDTO = converter.apply(clientChangeAddressRequest);

        assertThat(clientDTO, notNullValue());
        assertEquals(clientChangeAddressRequest.getDocument(), clientDTO.getDocument());
        assertEquals(clientChangeAddressRequest.getAddress().getCity(), clientDTO.getAddressDTO().getCity());
        assertEquals(clientChangeAddressRequest.getAddress().getNumber(), clientDTO.getAddressDTO().getNumber());
        assertEquals(clientChangeAddressRequest.getAddress().getState(), clientDTO.getAddressDTO().getState());
        assertEquals(clientChangeAddressRequest.getAddress().getStreet(), clientDTO.getAddressDTO().getStreet());
        assertEquals(clientChangeAddressRequest.getAddress().getZipcode(), clientDTO.getAddressDTO().getZipcode());

    }

    @Test
    public void shouldValidateddressRequestNull(){

        ClientChangeAddressRequest clientChangeAddressRequest = from(ClientChangeAddressRequest.class).
                gimme(CLIENT_CHANGE_ADDRESS_REQUEST);
        clientChangeAddressRequest.withAddress(null);

        ClientDTO clientDTO = converter.apply(clientChangeAddressRequest);

        assertNull(clientDTO.getAddressDTO());

    }

    @Test
    public void shouldValidateClientChangeAddressRequestNull(){

        ClientDTO clientDTO = converter.apply(null);

        assertNull(clientDTO);
    }

}