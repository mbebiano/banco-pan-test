package com.example.bancopan.controller.response;

import com.google.gson.annotations.SerializedName;

public class RegionResponse {

    @SerializedName("id")
    private String regionId;

    @SerializedName("sigla")
    private String regionAcronym;

    @SerializedName("nome")
    private String name;

    public String getRegionId() {
        return regionId;
    }

    public RegionResponse withRegionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public String getRegionAcronym() {
        return regionAcronym;
    }

    public RegionResponse withRegionAcronym(String regionAcronym) {
        this.regionAcronym = regionAcronym;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegionResponse withName(String name) {
        this.name = name;
        return this;
    }
}
