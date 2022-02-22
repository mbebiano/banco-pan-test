package com.example.bancopan.service;

import com.example.bancopan.controller.response.CitiesResponse;
import com.example.bancopan.dto.StateDTO;

import java.util.List;

public interface StateService {

    List<CitiesResponse> listAllCitiesByState(String state);

    List<StateDTO> findAllStates();

}