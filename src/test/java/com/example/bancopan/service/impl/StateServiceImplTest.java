package com.example.bancopan.service.impl;

import com.example.bancopan.BaseTest;
import com.example.bancopan.connector.api.ServicosDadosIbgeAPI;
import com.example.bancopan.controller.response.CitiesResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;
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
import static com.example.bancopan.fixture.CitiesResponseFixture.CITIES_RESPONSE;
import static com.example.bancopan.fixture.StateDTOFixture.*;
import static com.example.bancopan.fixture.StateIBGEResponseFixture.*;
import static java.math.BigInteger.ONE;
import static org.mockito.Mockito.*;

public class StateServiceImplTest extends BaseTest {

    @Mock private ServicosDadosIbgeAPI servicosDadosIbgeAPI;
    @Mock private StateIBGEResponseToStateDTOConverter stateDTOConverter;

    @InjectMocks
    private StateServiceImpl service;

    @Test
    public void shouldSucessToFindOneState() {

        List<StateIBGEResponse> stateIBGEResponse = Collections.singletonList(from(StateIBGEResponse.class).
                gimme(STATE_IBGE_RESPONSE));

        List<StateDTO> stateDTOS = Collections.singletonList(from(StateDTO.class).
                gimme(STATE_DTO));

        when(stateDTOConverter.apply(anyList())).thenReturn(stateDTOS);
        when(servicosDadosIbgeAPI.getAllStates()).thenReturn(stateIBGEResponse);

        List<StateDTO> stateDTOSReturn = service.findAllStates();

        Assert.assertEquals(stateIBGEResponse.size(), stateDTOSReturn.size());
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).getAllStates();

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

        when(servicosDadosIbgeAPI.getAllStates()).thenReturn(stateIBGEResponse);
        when(stateDTOConverter.apply(anyList())).thenReturn(stateDTOS);

        List<StateDTO> stateDTOSReturned = service.findAllStates();

        Assert.assertEquals(stateIBGEResponse.size(), stateDTOSReturned.size());
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).getAllStates();

    }

    @Test(expected = StateNotFoundException.class)
    public void shouldFailedToFindStates() {

        when(stateDTOConverter.apply(anyList())).thenReturn(null);
        when(servicosDadosIbgeAPI.getAllStates()).thenReturn(null);

        List<StateDTO> stateDTOSReturned = service.findAllStates();

        Assert.assertNull(stateDTOSReturned);
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).getAllStates();

    }

    @Test
    public void shouldSucessListCitiesByStateId() {

        StateIBGEResponse stateIBGEResponse = from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE);
        List<StateIBGEResponse> stateIBGEResponses = Collections.singletonList(stateIBGEResponse);
        List<CitiesResponse> citiesResponses = Collections.singletonList(from(CitiesResponse.class).
                gimme(CITIES_RESPONSE));

        when(servicosDadosIbgeAPI.getAllStates()).thenReturn(stateIBGEResponses);
        when(servicosDadosIbgeAPI.findAllCitiesByStateId
                (Integer.parseInt(stateIBGEResponse.getStateId()))).thenReturn(citiesResponses);

        List<CitiesResponse> citiesResponsesReturn = service.listAllCitiesByState(stateIBGEResponse.getAcronym());

        Assert.assertEquals(citiesResponses.size(), citiesResponsesReturn.size());
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).getAllStates();
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).findAllCitiesByStateId(anyInt());

    }

    @Test(expected = StateNotFoundException.class)
    public void shouldFailedListCitiesByStateNotFoundState() {

        StateIBGEResponse stateIBGEResponse = from(StateIBGEResponse.class).gimme(STATE_IBGE_RESPONSE);
        List<StateIBGEResponse> stateIBGEResponses = Collections.singletonList(stateIBGEResponse);
        List<CitiesResponse> citiesResponses = Collections.singletonList(from(CitiesResponse.class).
                gimme(CITIES_RESPONSE));

        when(servicosDadosIbgeAPI.getAllStates()).thenReturn(stateIBGEResponses);
        when(servicosDadosIbgeAPI.findAllCitiesByStateId
                (Integer.parseInt(stateIBGEResponse.getStateId()))).thenReturn(citiesResponses);

        List<CitiesResponse> citiesResponsesReturn = service.listAllCitiesByState("MZ");

        Assert.assertEquals(citiesResponses.size(), citiesResponsesReturn.size());
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).getAllStates();
        verify(this.servicosDadosIbgeAPI, times(ONE.intValue())).findAllCitiesByStateId(anyInt());

    }

}