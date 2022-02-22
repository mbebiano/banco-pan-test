package com.example.bancopan.converter;

import com.example.bancopan.controller.request.AddressChangeRequest;
import com.example.bancopan.controller.request.ClientChangeAddressRequest;
import com.example.bancopan.dto.AddressDTO;
import com.example.bancopan.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.util.Objects.isNull;

@Component
public class ClientChangeAdressRequestToClientDTOConverter implements Function<ClientChangeAddressRequest, ClientDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientChangeAdressRequestToClientDTOConverter.class);

    @Override
    public ClientDTO apply(ClientChangeAddressRequest clientChangeAddressRequest) {

        LOGGER.info("stage=init method=ClientChangeAdressRequestToClientDTOConverter.apply request={}",
                clientChangeAddressRequest);

        if (isNull(clientChangeAddressRequest)){
            return null;
        }

        ClientDTO clientDTO = new ClientDTO().withDocument(clientChangeAddressRequest.getDocument())
                .withAddressDTO(this.getAdressDto(clientChangeAddressRequest.getAddress()));

        LOGGER.info("stage=end method=ClientChangeAdressRequestToClientDTOConverter.apply clientDTO={}",
                clientDTO);

        return clientDTO;
    }

    private AddressDTO getAdressDto(AddressChangeRequest request) {
        if (isNull(request)){
            return null;
        }
        return new AddressDTO().withCity(request.getCity())
                .withNumber(request.getNumber())
                .withState(request.getState())
                .withStreet(request.getStreet())
                .withZipcode(request.getZipcode());
    }

}