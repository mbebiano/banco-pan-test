package com.example.bancopan.repository;

import com.example.bancopan.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findClientByDocument(String document);
}
