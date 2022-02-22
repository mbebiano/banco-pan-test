package com.example.bancopan.service.impl;

import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.converter.AddressToAddressResponseConverter;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.Client;
import com.example.bancopan.domain.Gender;
import com.example.bancopan.domain.State;
import com.example.bancopan.dto.AddressDTO;
import com.example.bancopan.dto.ClientDTO;
import com.example.bancopan.exceptions.ClientFoundException;
import com.example.bancopan.exceptions.ClientNotFoundException;
import com.example.bancopan.repository.ClientRepository;
import com.example.bancopan.service.AddressService;
import com.example.bancopan.service.ClientService;
import com.example.bancopan.validations.validator.CPFValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository repository;

    private final CPFValidator cpfValidator;

    private final AddressService addressService;

    private final AddressToAddressResponseConverter addressResponseConverter;

    public ClientServiceImpl(ClientRepository repository,
                             CPFValidator cpfValidator, AddressService addressService,
                             AddressToAddressResponseConverter addressResponseConverter){

        this.repository = repository;
        this.cpfValidator = cpfValidator;
        this.addressService = addressService;
        this.addressResponseConverter = addressResponseConverter;
    }

    @Override
    public ClientDTO findByDocument(String document) {

        LOGGER.info("stage=init method=ClientServiceImpl.findByDocument "
                + "Message=Find Client by document={}", document);

        ClientDTO clientDTO = createClientResponse(this.getClientByDocument(document));

        LOGGER.info("stage=init method=ClientServiceImpl.findByDocument "
                + "Message=Create Client Response={}", clientDTO);

        return clientDTO;
    }

    @Override
    public ClientDTO changeClientAddress(ClientDTO clientDTO) {

        LOGGER.info("stage=init method=ClientServiceImpl.changeClientAddress "
                + "Message=Change client address={}", clientDTO.getDocument());

        Client clientFound = this.getClientByDocument(clientDTO.getDocument());

        AddressResponse response = addressService.findByZipCode(clientDTO.getAddressDTO().getZipcode());

        Address address =  addressResponseConverter.apply(clientDTO.getAddressDTO(), response);

        clientFound.withAddress(address);

        repository.save(clientFound);

        ClientDTO clientDTOReturn = clientDTO.withAddressDTO(new AddressDTO(address));

        LOGGER.info("stage=end method=ClientServiceImpl.changeClientAddress "
                + "Message=Change client address={}", clientDTOReturn.getDocument());

        return clientDTOReturn;
    }

    private ClientDTO createClientResponse(Client client){
        return new ClientDTO().withDocument(client.getDocument())
                .withEmail(client.getEmail())
                .withLastName(client.getLastName())
                .withFirstName(client.getFirstName())
                .withAddressDTO(new AddressDTO(client.getAddress()));
    }

    private Client getClientByDocument(String document){

        LOGGER.info("stage=init method=ClientServiceImpl.getClientByDocument "
                + "Message=Find Client by document={}", document);

        cpfValidator.isValidatedCPF(document);

        Client client = repository.findClientByDocument(document);

        if (isNull(client)){
            LOGGER.error("stage=error method=ClientServiceImpl.getClientByDocument" +
                    " message=Client not found by document={}", document);
            throw new ClientNotFoundException("Client not found");
        }

        LOGGER.info("stage=end method=ClientServiceImpl.getClientByDocument "
                + "Message=FoundClient by document={}", document);

        return client;
    }

    @Override
    public void populatedDatabase(){

        Client client = new Client().withAddress(
                new Address().withCity("Juiz de Fora")
                        .withNumber("475")
                        .withState(State.MG)
                        .withStreet("Aurora tristão")
                        .withZipCode("36047100"))
                .withEmail("mattheus.bebiano@engenharia.ufjf.br")
                .withDocument("53313289037")
                .withGender(Gender.MALE)
                .withFirstName("Mattheus")
                .withLastName("Bebiano");

        Client clientFound = repository.findClientByDocument(client.getDocument());

        if (!isNull(clientFound)){
            throw new ClientFoundException("Already populated database");
        }

        repository.save(client);

    }

}