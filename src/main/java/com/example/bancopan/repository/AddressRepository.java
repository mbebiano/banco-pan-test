package com.example.bancopan.repository;

import com.example.bancopan.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findAddressByZipcode(String zipCode);

}
