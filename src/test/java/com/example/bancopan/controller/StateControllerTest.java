package com.example.bancopan.controller;


import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.CitiesResponse;
import com.example.bancopan.dto.StateDTO;
import com.example.bancopan.fixture.CitiesResponseFixture;
import com.example.bancopan.fixture.StateDTOFixture;
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
		List<StateDTO> stateIBGEResponses = Collections.singletonList(from(StateDTO.class).
				gimme(StateDTOFixture.STATE_DTO));

		when(service.findAllStates()).thenReturn(stateIBGEResponses);

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
		List<CitiesResponse> citiesResponses = Collections.singletonList(from(CitiesResponse.class).
				gimme(CitiesResponseFixture.CITIES_RESPONSE));

		when(service.listAllCitiesByState(state)).thenReturn(citiesResponses);

		mvc.perform(MockMvcRequestBuilders
						.get(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}
	
}
