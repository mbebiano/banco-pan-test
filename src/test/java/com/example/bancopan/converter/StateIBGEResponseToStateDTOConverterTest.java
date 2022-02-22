package com.example.bancopan.converter;

import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.StateIBGEResponse;
import com.example.bancopan.dto.StateDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.StateIBGEResponseFixture.STATE_IBGE_RESPONSE;
import static org.junit.Assert.*;

public class StateIBGEResponseToStateDTOConverterTest extends BaseTest {

    private StateIBGEResponseToStateDTOConverter converter;

    @Before
    public void before() {
        this.converter = new StateIBGEResponseToStateDTOConverter();
    }

    @Test
    public void shouldStateIBGEResponseToStateDTO(){

        List<StateIBGEResponse> stateIBGEResponses = Collections.singletonList(from(StateIBGEResponse.class)
                .gimme(STATE_IBGE_RESPONSE));

        List<StateDTO> stateDTOS = converter.apply(stateIBGEResponses);

        assertFalse(stateDTOS.isEmpty());
        assertEquals(stateIBGEResponses.size(), stateDTOS.size());

    }

    @Test
    public void shouldValidateNull(){

        List<StateDTO> stateDTOS = converter.apply(null);

        assertNull(stateDTOS);
    }

}