package com.example.bancopan.controller;

import com.example.bancopan.controller.response.CitiesResponse;
import com.example.bancopan.dto.StateDTO;
import com.example.bancopan.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateController.class);

    private StateService service;

    public StateController(StateService service) {
        this.service = service;
    }

    @GetMapping(value = "/listAllStates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StateDTO>> listAllStates() {

        LOGGER.info("stage=init method=StateController.listAllStates");

        List<StateDTO> response = this.service.findAllStates();

        LOGGER.info("stage=end method=StateController.listAllStates response={}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping(value = "/{state}/listAllCitiesByState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CitiesResponse>> listAllCitiesByState(@PathVariable(value = "state") String state) {

        LOGGER.info("stage=init method=StateController.listAllCitiesByState");

        List<CitiesResponse> response = this.service.listAllCitiesByState(state);

        LOGGER.info("stage=end method=StateController.listAllCitiesByState response={}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}