package com.example.bancopan.service.impl;

import com.example.bancopan.connector.api.IBGEDataServiceAPI;
import com.example.bancopan.controller.response.CityResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;
import com.example.bancopan.controller.response.StateResponse;
import com.example.bancopan.converter.StateDTOToStateResponseConverter;
import com.example.bancopan.converter.StateIBGEResponseToStateDTOConverter;
import com.example.bancopan.dto.StateDTO;
import com.example.bancopan.exceptions.StateNotFoundException;
import com.example.bancopan.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class StateServiceImpl implements StateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateServiceImpl.class);

    private final IBGEDataServiceAPI IBGEDataServiceAPI;

    private final StateIBGEResponseToStateDTOConverter stateDTOConverter;

    private final StateDTOToStateResponseConverter stateResponseConverter;

    private final List<String> listOfStatesInOrderOfPriority = List.of("SP", "RJ");


    public StateServiceImpl(IBGEDataServiceAPI IBGEDataServiceAPI,
                            StateIBGEResponseToStateDTOConverter stateDTOConverter, StateDTOToStateResponseConverter stateResponseConverter) {

        this.IBGEDataServiceAPI = IBGEDataServiceAPI;
        this.stateDTOConverter = stateDTOConverter;
        this.stateResponseConverter = stateResponseConverter;
    }

    @Override
    public List<CityResponse> listAllCitiesByState(String state) {

        LOGGER.info("stage=init method=StateServiceImpl.listAllCitiesByState "
                + "Message=Find all cities by state");

        List<StateIBGEResponse> stateIBGEResponseReturned = this.getStatesFromIbge();

        StateIBGEResponse stateIBGEResponseFound = stateIBGEResponseReturned.stream().
                filter(stateResponse -> state.toUpperCase(Locale.ROOT).
                        equals(stateResponse.getAcronym().toUpperCase(Locale.ROOT))).
                findFirst().orElse(null);

        if (stateIBGEResponseFound == null) {
            LOGGER.error("stage=error method=StateServiceImpl.listAllCitiesByState "
                    + "Message=No state found for = {}", state);
            throw new StateNotFoundException(String.format("There is no State with name (%s)", state));
        }

        LOGGER.info("stage=end method=StateServiceImpl.listAllCitiesByState "
                + "Message=Find all cities by state");

        return IBGEDataServiceAPI.
                findAllCitiesByStateId(Integer.parseInt(stateIBGEResponseFound.getStateId()));

    }

    @Override
    public List<StateResponse> findAllStates() {

        LOGGER.info("stage=init method=AddressServiceImpl.findAllStates "
                + "Message=Find all States");

        List<StateIBGEResponse> stateIBGEResponseReturned = this.getStatesFromIbge();

        List<StateIBGEResponse> statesOrdered =
                this.listOfStatesOrderedByPriorityAndAcronym(stateIBGEResponseReturned);

        List<StateDTO> stateDTOS = stateDTOConverter.apply(statesOrdered);

        List<StateResponse> stateResponses = stateResponseConverter.apply(stateDTOS);

        LOGGER.info("stage=init method=AddressServiceImpl.findAllStates "
                + "Message=States size={}", statesOrdered.size());

        return stateResponses;
    }

    private List<StateIBGEResponse> getStatesFromIbge() {

        LOGGER.info("stage=init method=AddressServiceImpl.getStatesFromIbge "
                + "Message=Get all States");

        List<StateIBGEResponse> stateIBGEResponseReturned = IBGEDataServiceAPI.getAllStates();

        if (isEmpty(stateIBGEResponseReturned)) {
            LOGGER.error("stage=end method=AddressServiceImpl.findAllStates message=States not found");
            throw new StateNotFoundException("States not found");
        }

        LOGGER.info("stage=end method=AddressServiceImpl.getStatesFromIbge "
                + "Message=Finish get all States");

        return stateIBGEResponseReturned;
    }


    private List<StateIBGEResponse> listOfStatesOrderedByPriorityAndAcronym
            (List<StateIBGEResponse> listOfStates) {

        Map<String, StateIBGEResponse> mapStates = listOfStates.stream()
                .collect(Collectors.toMap(StateIBGEResponse::getAcronym, StateIBGEResponse -> StateIBGEResponse,
                        (oldValue, newValue) -> newValue));

        List<StateIBGEResponse> returnList = new ArrayList<>();

        listOfStatesInOrderOfPriority.forEach(statesPriority -> {
            if (nonNull(mapStates.get(statesPriority))) {
                returnList.add(mapStates.get(statesPriority));
                mapStates.remove(statesPriority);
            }
        });

        List<StateIBGEResponse> reordededList = new ArrayList<>(mapStates.values());

        returnList.addAll(this.sortListByAcronyms(reordededList));

        return returnList;
    }


    private List<StateIBGEResponse> sortListByAcronyms(List<StateIBGEResponse> stateIBGEResponseReturned) {

        return stateIBGEResponseReturned.stream().
                sorted(Comparator.comparing(StateIBGEResponse::getAcronym))
                .collect(Collectors.toList());

    }

}