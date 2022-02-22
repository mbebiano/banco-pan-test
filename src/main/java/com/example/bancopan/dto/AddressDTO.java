package com.example.bancopan.dto;

import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.State;

public class AddressDTO {

    private String zipcode;

    private String street;

    private String number;

    private String city;

    private State state;

    public AddressDTO (){

    }

    public AddressDTO (Address address){

        this.zipcode = address.getZipcode();

        this.state = address.getState();

        this.street = address.getStreet();

        this.number = address.getNumber();

        this.city = address.getCity();

    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressDTO withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDTO withStreet(String street) {
        this.street = street;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressDTO withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDTO withCity(String city) {
        this.city = city;
        return this;
    }

    public State getState() {
        return state;
    }

    public AddressDTO withState(State state) {
        this.state = state;
        return this;
    }
}
