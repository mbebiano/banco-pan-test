package com.example.bancopan.controller;

import com.example.bancopan.controller.request.ClientChangeAddressRequest;
import com.example.bancopan.controller.response.ClientChangedAddressResponse;
import com.example.bancopan.controller.response.ClientResponse;
import com.example.bancopan.converter.ClientChangeAdressRequestToClientDTOConverter;
import com.example.bancopan.converter.ClientDTOToClientResponseConverter;
import com.example.bancopan.dto.ClientDTO;
import com.example.bancopan.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientService service;

    private final ClientDTOToClientResponseConverter clientDTOtoClientResponseConverter;

    private final ClientChangeAdressRequestToClientDTOConverter clientChangeAdressConverter;

    public ClientController(ClientService service,
                            ClientDTOToClientResponseConverter clientDTOtoClientResponseConverter,
                            ClientChangeAdressRequestToClientDTOConverter clientChangeAdressConverter){
        this.service = service;
        this.clientDTOtoClientResponseConverter = clientDTOtoClientResponseConverter;
        this.clientChangeAdressConverter = clientChangeAdressConverter;
    }

    @GetMapping(value = "/{document}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> getClientByDocument(@PathVariable(value = "document") String document) {

        LOGGER.info("stage=init method=ClientController.getClientByDocument document={}", document);

        ClientDTO clientDTO = this.service.findByDocument(document);

        ClientResponse clientResponse = clientDTOtoClientResponseConverter.apply(clientDTO);

        LOGGER.info("stage=end method=ClientController.getClientByDocument response={}", clientResponse);

        return new ResponseEntity<>(clientResponse, HttpStatus.OK);

    }

    @PutMapping(value = "/changeAddress", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> clientChangeAddress(
            @RequestBody ClientChangeAddressRequest request) {

        LOGGER.info("stage=init method=ClientController.clientChangeAddress "
                + "Message=Client change Address Request={}", request);

        ClientDTO clientDTO = this.clientChangeAdressConverter.apply(request);

        service.changeClientAddress(clientDTO);

        ClientChangedAddressResponse clientResponse = new ClientChangedAddressResponse().
                withAddress(clientDTO.getAddressDTO());

        LOGGER.info("stage=end method=ClientController.clientChangeAddress "
                + "Message=Finished Client change response={}", clientResponse);

        return new ResponseEntity<>(clientResponse, HttpStatus.OK);

    }

    @PostMapping(value = "/populatedData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> populatedData() {

        LOGGER.info("stage=init method=ClientController.populatedData Initialize Populated Data");

        this.service.populatedDatabase();

        LOGGER.info("stage=init method=ClientController.populatedData End Populated Data");

        return new ResponseEntity<>(HttpStatus.OK);

    }

}