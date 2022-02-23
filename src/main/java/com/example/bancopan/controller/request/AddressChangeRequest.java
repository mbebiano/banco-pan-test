package com.example.bancopan.controller.request;

import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.enums.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressChangeRequest {

    @NotBlank(message = "You must fill in the zipcode")
    private String zipcode;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String city;

    @NotNull
    private State state;

    public AddressChangeRequest(){

    }

    public AddressChangeRequest(Address address){

        this.zipcode = address.getZipcode();

        this.state = address.getState();

        this.street = address.getStreet();

        this.number = address.getNumber();

        this.city = address.getCity();

    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressChangeRequest withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressChangeRequest withStreet(String street) {
        this.street = street;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressChangeRequest withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressChangeRequest withCity(String city) {
        this.city = city;
        return this;
    }

    public State getState() {
        return state;
    }

    public AddressChangeRequest withState(State state) {
        this.state = state;
        return this;
    }
}
