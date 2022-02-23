package com.example.bancopan.controller;


import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.CityResponse;
import com.example.bancopan.controller.response.StateResponse;
import com.example.bancopan.fixture.CityResponseFixture;
import com.example.bancopan.fixture.StateResponseFixture;
import com.example.bancopan.service.StateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(StateController.class)
public class StateControllerTest extends BaseTest {

	private final String PATH = "/api/states";
	
	@Autowired
    private MockMvc mvc;
	
	@InjectMocks private StateController controller;
	@MockBean private StateService service;


	@Test
	public void shouldListAllStates() throws Exception {

		String endpoint = "listAllStates";
		String url = PATH +"/" + endpoint;
		List<StateResponse> stateResponses = Collections.singletonList(from(StateResponse.class).
				gimme(StateResponseFixture.STATE_RESPONSE));

		when(service.findAllStates()).thenReturn(stateResponses);

		mvc.perform(MockMvcRequestBuilders
						.get(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void shouldListAllCitiesByState() throws Exception {

		String endpoint = "/listAllCitiesByState";
		String state = "/MG";
		String url = PATH + state + endpoint;
		List<CityResponse> cityRespons = Collections.singletonList(from(CityResponse.class).
				gimme(CityResponseFixture.CITIES_RESPONSE));

		when(service.listAllCitiesByState(state)).thenReturn(cityRespons);

		mvc.perform(MockMvcRequestBuilders
						.get(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}
	
}
