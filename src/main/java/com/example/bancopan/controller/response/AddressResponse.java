package com.example.bancopan.controller.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class AddressResponse {

    @SerializedName("cep")
    private String zipCode;

    @SerializedName("logradouro")
    private String street;

    @SerializedName("complemento")
    private String complement;

    @SerializedName("bairro")
    private String district;

    @SerializedName("localidade")
    private String city;

    @SerializedName("uf")
    private String state;

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public AddressResponse zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressResponse street(String street) {
        this.street = street;
        return this;
    }

    public AddressResponse complement(String complement) {
        this.complement = complement;
        return this;
    }

    public AddressResponse district(String district) {
        this.district = district;
        return this;
    }

    public AddressResponse state(String state) {
        this.state = state;
        return this;
    }

    public AddressResponse city(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}