package com.example.bancopan.connector.api;

import com.example.bancopan.controller.response.CityResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface IBGEDataServiceAPI {

    @RequestLine("GET ")
    List<StateIBGEResponse> getAllStates();

    @RequestLine("GET /{stateId}/municipios")
    List<CityResponse> findAllCitiesByStateId(@Param("stateId") int stateId);
}
