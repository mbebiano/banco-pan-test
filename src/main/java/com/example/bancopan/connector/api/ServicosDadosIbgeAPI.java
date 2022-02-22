package com.example.bancopan.connector.api;

import com.example.bancopan.controller.response.CitiesResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface ServicosDadosIbgeAPI {

    @RequestLine("GET ")
    List<StateIBGEResponse> getAllStates();

    @RequestLine("GET /{stateId}/municipios")
    List<CitiesResponse> findAllCitiesByStateId(@Param("stateId") int stateId);
}
