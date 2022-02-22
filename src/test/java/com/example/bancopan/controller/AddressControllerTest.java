package com.example.bancopan.controller;


import com.example.bancopan.BaseTest;
import com.example.bancopan.controller.response.AddressResponse;
import com.example.bancopan.fixture.AddressResponseFixture;
import com.example.bancopan.service.AddressService;
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
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(AddressController.class)
public class AddressControllerTest extends BaseTest {

	private final String PATH = "/api/address";
	
	@Autowired
    private MockMvc mvc;
	
	@InjectMocks private AddressController controller;
	@MockBean private AddressService service;


	@Test
	public void shouldGetAddressByZipCode() throws Exception {

		String zipCode = "/36047100";

		String url = PATH + zipCode;

		AddressResponse addressResponses = from(AddressResponse.class).gimme(AddressResponseFixture.ADDRESS_RESPONSE);

		when(service.findByZipCode(zipCode)).thenReturn(addressResponses);

		mvc.perform(MockMvcRequestBuilders
						.get(url)
						.contentType(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());

	}
	
}