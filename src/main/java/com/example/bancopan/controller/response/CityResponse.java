package com.example.bancopan.controller.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class CityResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("nome")
    private String name;


    public String getId() {
        return id;
    }

    public CityResponse withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CityResponse withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityResponse that = (CityResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}