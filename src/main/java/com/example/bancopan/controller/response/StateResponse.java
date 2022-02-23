package com.example.bancopan.controller.response;

import com.google.gson.Gson;

public class StateResponse {

    private String name;

    private String acronym;

    public String getName() {
        return name;
    }

    public StateResponse withName(String name) {
        this.name = name;
        return this;
    }

    public String getAcronym() {
        return acronym;
    }

    public StateResponse withAcronym(String acronym) {
        this.acronym = acronym;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}