package com.example.bancopan.controller;


import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.request.ClientChangeAddressRequest;
import com.example.bancopan.controller.response.ClientResponse;
import com.example.bancopan.converter.ClientChangeAdressRequestToClientDTOConverter;
import com.example.bancopan.converter.ClientDTOToClientResponseConverter;
import com.example.bancopan.dto.ClientDTO;
import com.example.bancopan.fixture.ClientDTOFixture;
import com.example.bancopan.fixture.ClientResponseFixture;
import com.example.bancopan.service.ClientService;
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

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.example.bancopan.fixture.ClientChangeAddressRequestFixture.CLIENT_CHANGE_ADDRESS_REQUEST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ClientController.class)
public class ClientControllerTest extends BaseTest {

	private final String PATH = "/api/client";
	
	@Autowired
    private MockMvc mvc;
	
	@InjectMocks private ClientController controller;
	@MockBean private ClientService service;
	@MockBean private ClientDTOToClientResponseConverter clientDTOtoClientResponseConverter;
	@MockBean private ClientChangeAdressRequestToClientDTOConverter clientChangeAdressConverter;


	@Test
	public void shouldGetClientByDocument() throws Exception {

		String document = "53313289037";
		String url = PATH +"/" + document;
		ClientResponse clientResponse = from(ClientResponse.class).gimme(ClientResponseFixture.CLIENT_RESPONSE);
		ClientDTO clientDTO = from(ClientDTO.class).gimme(ClientDTOFixture.CLIENT_DTO);


		when(service.findByDocument(document)).thenReturn(clientDTO);

		when(clientDTOtoClientResponseConverter.apply(any())).thenReturn(clientResponse);

		mvc.perform(MockMvcRequestBuilders
						.get(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}


	@Test
	public void shouldClientChangeAddress() throws Exception {

		String endpoint = "/changeAddress";
		String url = PATH + endpoint;
		ClientChangeAddressRequest request = from(ClientChangeAddressRequest.class).gimme(CLIENT_CHANGE_ADDRESS_REQUEST);
		ClientResponse clientResponse = from(ClientResponse.class).gimme(ClientResponseFixture.CLIENT_RESPONSE);
		ClientDTO clientDTO = from(ClientDTO.class).gimme(ClientDTOFixture.CLIENT_DTO);

		when(service.changeClientAddress(clientDTO)).thenReturn(clientDTO);
		when(clientChangeAdressConverter.apply(any())).thenReturn(clientDTO);
		when(clientDTOtoClientResponseConverter.apply(any())).thenReturn(clientResponse);

		mvc.perform(MockMvcRequestBuilders
						.put(url)
						.content(asJsonString(request))
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void shouldClientChangeAddressWithoutRequest() throws Exception {

		String endpoint = "/changeAddress";
		String url = PATH + endpoint;
		ClientResponse clientResponse = from(ClientResponse.class).gimme(ClientResponseFixture.CLIENT_RESPONSE);
		ClientDTO clientDTO = from(ClientDTO.class).gimme(ClientDTOFixture.CLIENT_DTO);

		when(service.changeClientAddress(clientDTO)).thenReturn(clientDTO);
		when(clientChangeAdressConverter.apply(any())).thenReturn(clientDTO);
		when(clientDTOtoClientResponseConverter.apply(any())).thenReturn(clientResponse);

		mvc.perform(MockMvcRequestBuilders
						.put(url)
						.content(asJsonString(null))
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isBadRequest());

	}

	@Test
	public void shouldSucessPopulatedData() throws Exception {

		String endpoint = "/populatedData";
		String url = PATH + endpoint;

		mvc.perform(MockMvcRequestBuilders
						.post(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}

}
