package com.example.bancopan.converter;

import com.example.bancopan.controller.response.StateIBGEResponse;
import com.example.bancopan.dto.StateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Component
public class StateIBGEResponseToStateDTOConverter implements Function<List<StateIBGEResponse>, List<StateDTO>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateIBGEResponseToStateDTOConverter.class);

    @Override
    public List<StateDTO> apply(List<StateIBGEResponse> stateIBGEResponses) {

        LOGGER.info("stage=init method=StateIBGEResponseToStateDTOConverter.apply");

        List<StateDTO> stateDTOS = new ArrayList<>();

        if (isEmpty(stateIBGEResponses)){
            return null;
        }

        stateIBGEResponses.forEach(stateIBGEResponse -> stateDTOS.add(new StateDTO()
                .withAcronym(stateIBGEResponse.getAcronym())
                .withName(stateIBGEResponse.getName())));

        LOGGER.info("stage=end method=StateIBGEResponseToStateDTOConverter.apply stateDTOS size={}",
                stateDTOS.size());

        return stateDTOS;
    }

}