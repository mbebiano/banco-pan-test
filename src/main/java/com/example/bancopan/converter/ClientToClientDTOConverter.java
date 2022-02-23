package com.example.bancopan.converter;

import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.Client;
import com.example.bancopan.dto.AddressDTO;
import com.example.bancopan.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.util.Objects.isNull;

@Component
public class ClientToClientDTOConverter implements Function<Client, ClientDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientToClientDTOConverter.class);

    @Override
    public ClientDTO apply(Client client) {

        LOGGER.info("stage=init method=ClientToClientDTOConverter.apply client={}",
                client);

        ClientDTO clientDTO = new ClientDTO();

        if (isNull(client)){
            return null;
        }

        clientDTO.withFirstName(client.getFirstName())
                .withLastName(client.getLastName())
                .withEmail(client.getEmail())
                .withDocument(client.getDocument())
                .withAddressDTO(this.getAddressDTOByAddress(client.getAddress()));

        LOGGER.info("stage=end method=ClientToClientDTOConverter.apply clientDTO={}",
                clientDTO);

        return clientDTO;
    }

    private AddressDTO getAddressDTOByAddress(Address address){
        return new AddressDTO(address);
    }

}