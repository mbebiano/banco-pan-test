package com.example.bancopan.service.impl;

import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.converter.AddressToAddressResponseConverter;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.Client;
import com.example.bancopan.domain.State;
import com.example.bancopan.dto.ClientDTO;
import com.example.bancopan.exceptions.ClientNotFoundException;
import com.example.bancopan.repository.ClientRepository;
import com.example.bancopan.service.AddressService;
import com.example.bancopan.validations.validator.CPFValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.AddressFixture.ADDRESS;
import static com.example.bancopan.fixture.AddressResponseFixture.ADDRESS_RESPONSE;
import static com.example.bancopan.fixture.ClientDTOFixture.CLIENT_DTO;
import static com.example.bancopan.fixture.ClientFixture.CLIENT;
import static java.math.BigInteger.ONE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClientServiceImplTest extends BaseTest {

    @Mock private ClientRepository repository;
    @Mock private CPFValidator cpfValidator;
    @Mock private AddressService addressService;
    @Mock private AddressToAddressResponseConverter addressResponseConverter;

    @InjectMocks
    private ClientServiceImpl service;

    @Test
    public void shouldSucessToFindClientByDocument() {

        Client client = from(Client.class).gimme(CLIENT);

        when(repository.findClientByDocument(client.getDocument())).thenReturn(client);

        ClientDTO clientDTO = service.findByDocument(client.getDocument());

        Assert.assertNotNull(clientDTO);
        Assert.assertEquals(client.getDocument(), clientDTO.getDocument());
        Assert.assertEquals(client.getEmail(), clientDTO.getEmail());
        Assert.assertEquals(client.getFirstName(), clientDTO.getFirstName());
        Assert.assertEquals(client.getLastName(), clientDTO.getLastName());

        verify(this.repository, times(ONE.intValue())).findClientByDocument(anyString());

    }

    @Test(expected = ClientNotFoundException.class)
    public void shouldFailedToFindAddressByZipCodeNotFound() {

        Client client = from(Client.class).gimme(CLIENT);

        when(repository.findClientByDocument(client.getDocument())).thenReturn(null);

        ClientDTO clientDTO = service.findByDocument(client.getDocument());

        Assert.assertNull(clientDTO);
        verify(this.repository, times(ONE.intValue())).findClientByDocument(anyString());
    }

    @Test
    public void shouldSucessChangeClientAddress() {

        Client client = from(Client.class).gimme(CLIENT);
        ClientDTO clientDTO = from(ClientDTO.class).gimme(CLIENT_DTO);
        AddressResponse response = from(AddressResponse.class).gimme(ADDRESS_RESPONSE);
        Address address = from(Address.class).gimme(ADDRESS);

        when(repository.findClientByDocument(client.getDocument())).thenReturn(client);
        when(addressService.findByZipCode(any())).thenReturn(response);
        when(addressResponseConverter.apply(any(), any())).thenReturn(address);

        ClientDTO clientDTOReturn = service.changeClientAddress(clientDTO);

        Assert.assertNotNull(clientDTOReturn);
        Assert.assertEquals(clientDTOReturn.getAddressDTO().getZipcode(),
                response.getZipCode());
        Assert.assertEquals(clientDTOReturn.getAddressDTO().getCity(),
                response.getCity());
        Assert.assertEquals(clientDTOReturn.getAddressDTO().getState(),
                State.getEnum(response.getState()));

        verify(this.repository, times(ONE.intValue())).findClientByDocument(anyString());
        verify(this.addressService, times(ONE.intValue())).findByZipCode(anyString());
        verify(this.addressResponseConverter, times(ONE.intValue())).apply(any(), any());

    }

    @Test
    public void shouldSucessPopulatedDatabase() {

        service.populatedDatabase();

        verify(this.repository, times(ONE.intValue())).save(any());

    }

}