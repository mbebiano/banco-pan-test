package com.example.bancopan.service;

import com.example.bancopan.dto.ClientDTO;

public interface ClientService {

    ClientDTO findByDocument(String document);

    ClientDTO changeClientAddress(ClientDTO clientDTO);

    void populatedDatabase();

}
