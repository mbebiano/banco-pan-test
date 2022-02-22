package com.example.bancopan.dto;

import com.google.gson.Gson;

public class StateDTO {

    private String name;

    private String acronym;

    public String getName() {
        return name;
    }

    public StateDTO withName(String name) {
        this.name = name;
        return this;
    }

    public String getAcronym() {
        return acronym;
    }

    public StateDTO withAcronym(String acronym) {
        this.acronym = acronym;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}