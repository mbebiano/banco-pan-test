package com.example.bancopan.service;

import com.example.bancopan.controller.response.CityResponse;
import com.example.bancopan.controller.response.StateResponse;

import java.util.List;

public interface StateService {

    List<CityResponse> listAllCitiesByState(String state);

    List<StateResponse> findAllStates();

}