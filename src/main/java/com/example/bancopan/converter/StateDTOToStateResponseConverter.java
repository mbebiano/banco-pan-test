package com.example.bancopan.converter;

import com.example.bancopan.controller.response.StateResponse;
import com.example.bancopan.dto.StateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Component
public class StateDTOToStateResponseConverter implements Function<List<StateDTO>, List<StateResponse>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateDTOToStateResponseConverter.class);

    @Override
    public List<StateResponse> apply(List<StateDTO> stateDTOS) {

        LOGGER.info("stage=init method=StateDTOToStateResponseConverter.apply");

        List<StateResponse> stateResponses = new ArrayList<>();

        if (isEmpty(stateDTOS)){
            return null;
        }

        stateDTOS.forEach(state -> stateResponses.add(new StateResponse()
                .withAcronym(state.getAcronym())
                .withName(state.getName())));

        LOGGER.info("stage=end method=StateDTOToStateResponseConverter.apply stateResponses size={}",
                stateResponses.size());

        return stateResponses;
    }

}