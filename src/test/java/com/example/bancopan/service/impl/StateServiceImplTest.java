package com.example.bancopan.service.impl;

import com.example.bancopan.BaseTest;
import com.example.bancopan.connector.api.IBGEDataServiceAPI;
import com.example.bancopan.controller.response.CityResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;
import com.example.bancopan.controller.response.StateResponse;
import com.example.bancopan.converter.StateDTOToStateResponseConverter;
import com.example.bancopan.converter.StateIBGEResponseToStateDTOConverter;
import com.example.bancopan.dto.StateDTO;
import com.example.bancopan.exceptions.StateNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.CityResponseFixture.CITIES_RESPONSE;
import static com.example.bancopan.fixture.StateDTOFixture.*;
import static com.example.bancopan.fixture.StateIBGEResponseFixture.*;
import static com.example.bancopan.fixture.StateResponseFixture.*;
import static java.math.BigInteger.ONE;
import static org.mockito.Mockito.*;

public class StateServiceImplTest extends BaseTest {

    @Mock private IBGEDataServiceAPI IBGEDataServiceAPI;
    @Mock private StateIBGEResponseToStateDTOConverter stateDTOConverter;
    @Mock private StateDTOToStateResponseConverter stateResponseConverter;

    @InjectMocks
    private StateServiceImpl service;

    @Test
    public void shouldSucessToFindOneState() {

        List<StateIBGEResponse> stateIBGEResponse = Collections.singletonList(from(StateIBGEResponse.class).
                gimme(STATE_IBGE_RESPONSE));

        List<StateDTO> stateDTOS = Collections.singletonList(from(StateDTO.class).
                gimme(STATE_DTO));

        List<StateResponse> stateResponses = Collections.singletonList(from(StateResponse.class).
                gimme(STATE_RESPONSE));

        when(stateDTOConverter.apply(anyList())).thenReturn(stateDTOS);
        when(stateResponseConverter.apply(anyList())).thenReturn(stateResponses);
        when(IBGEDataServiceAPI.getAllStates()).thenReturn(stateIBGEResponse);

        List<StateResponse> stateResponsesReturn = service.findAllStates();

        Assert.assertEquals(stateIBGEResponse.size(), stateResponsesReturn.size());
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).getAllStates();

    }

    @Test
    public void shouldSucessToFindManyStates() {

        List<StateIBGEResponse> stateIBGEResponse = Arrays.asList(
                from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE),
                from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE_RJ),
                from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE_SP));

        List<StateDTO> stateDTOS = Arrays.asList(
                from(StateDTO.class).gimme(STATE_DTO),
                from(StateDTO.class).gimme(STATE_DTO_RJ),
                from(StateDTO.class).gimme(STATE_DTO_SP));

        List<StateResponse> stateResponses = Arrays.asList(
                from(StateResponse.class).gimme(STATE_RESPONSE),
                from(StateResponse.class).gimme(STATE_RESPONSE_RJ),
                from(StateResponse.class).gimme(STATE_RESPONSE_SP));

        when(stateResponseConverter.apply(anyList())).thenReturn(stateResponses);
        when(IBGEDataServiceAPI.getAllStates()).thenReturn(stateIBGEResponse);
        when(stateDTOConverter.apply(anyList())).thenReturn(stateDTOS);

        List<StateResponse> statesResponsesReturn = service.findAllStates();

        Assert.assertEquals(stateIBGEResponse.size(), statesResponsesReturn.size());
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).getAllStates();

    }

    @Test(expected = StateNotFoundException.class)
    public void shouldFailedToFindStates() {

        when(stateDTOConverter.apply(anyList())).thenReturn(null);
        when(stateResponseConverter.apply(anyList())).thenReturn(null);
        when(IBGEDataServiceAPI.getAllStates()).thenReturn(null);

        List<StateResponse> statesResponsesReturn = service.findAllStates();

        Assert.assertNull(statesResponsesReturn);
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).getAllStates();

    }

    @Test
    public void shouldSucessListCitiesByStateId() {

        StateIBGEResponse stateIBGEResponse = from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE);
        List<StateIBGEResponse> stateIBGEResponses = Collections.singletonList(stateIBGEResponse);
        List<CityResponse> cityRespons = Collections.singletonList(from(CityResponse.class).
                gimme(CITIES_RESPONSE));

        when(IBGEDataServiceAPI.getAllStates()).thenReturn(stateIBGEResponses);
        when(IBGEDataServiceAPI.findAllCitiesByStateId
                (Integer.parseInt(stateIBGEResponse.getStateId()))).thenReturn(cityRespons);

        List<CityResponse> cityResponsesReturn = service.listAllCitiesByState(stateIBGEResponse.getAcronym());

        Assert.assertEquals(cityRespons.size(), cityResponsesReturn.size());
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).getAllStates();
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).findAllCitiesByStateId(anyInt());

    }

    @Test(expected = StateNotFoundException.class)
    public void shouldFailedListCitiesByStateNotFoundState() {

        StateIBGEResponse stateIBGEResponse = from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE);
        List<StateIBGEResponse> stateIBGEResponses = Collections.singletonList(stateIBGEResponse);
        List<CityResponse> cityRespons = Collections.singletonList(from(CityResponse.class).
                gimme(CITIES_RESPONSE));

        when(IBGEDataServiceAPI.getAllStates()).thenReturn(stateIBGEResponses);
        when(IBGEDataServiceAPI.findAllCitiesByStateId
                (Integer.parseInt(stateIBGEResponse.getStateId()))).thenReturn(cityRespons);

        List<CityResponse> cityResponsesReturn = service.listAllCitiesByState("MZ");

        Assert.assertEquals(cityRespons.size(), cityResponsesReturn.size());
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).getAllStates();
        verify(this.IBGEDataServiceAPI, times(ONE.intValue())).findAllCitiesByStateId(anyInt());

    }

}