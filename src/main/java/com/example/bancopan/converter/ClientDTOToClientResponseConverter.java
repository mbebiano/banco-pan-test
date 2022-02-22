package com.example.bancopan.converter;

import com.example.bancopan.controller.response.ClientResponse;
import com.example.bancopan.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.util.Objects.isNull;

@Component
public class ClientDTOToClientResponseConverter implements Function<ClientDTO, ClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDTOToClientResponseConverter.class);

    @Override
    public ClientResponse apply(ClientDTO clientDTO) {

        LOGGER.info("stage=init method=ClientDTOToClientResponseConverter.apply clientDTO={}", clientDTO);

        if (isNull(clientDTO)){
            return null;
        }

        ClientResponse response = new ClientResponse().withFirstName(clientDTO.getFirstName())
                .withAddress(clientDTO.getAddressDTO())
                .withDocument(clientDTO.getDocument())
                .withEmail(clientDTO.getEmail())
                .withLastName(clientDTO.getLastName());

        LOGGER.info("stage=end method=ClientDTOToClientResponseConverter.apply");

        return response;
    }

}