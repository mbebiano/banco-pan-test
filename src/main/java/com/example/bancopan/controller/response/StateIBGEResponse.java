package com.example.bancopan.controller.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class StateIBGEResponse {

    @SerializedName("id")
    private String stateId;

    @SerializedName("sigla")
    private String acronym;

    @SerializedName("nome")
    private String name;

    @SerializedName("regiao")
    private RegionResponse region;

    public String getStateId() {
        return stateId;
    }

    public StateIBGEResponse withStateId(String stateId) {
        this.stateId = stateId;
        return this;
    }

    public String getAcronym() {
        return acronym;
    }

    public StateIBGEResponse withAcronym(String acronym) {
        this.acronym = acronym;
        return this;
    }

    public RegionResponse getRegion() {
        return region;
    }

    public StateIBGEResponse withRegion(RegionResponse region) {
        this.region = region;
        return this;
    }

    public String getName() {
        return name;
    }

    public StateIBGEResponse withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}