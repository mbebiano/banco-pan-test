package com.example.bancopan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.IOException;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.mockito.MockitoAnnotations.initMocks;

public class BaseTest {

	@Before
	public void before() {
		initMocks(this);
	}
	
	@BeforeClass
	public static void setUp() {
		loadTemplates("com.example.bancopan");
	}
	
	protected String asJsonString(Object value) {
		
		String converted = "";
		
		try {
			converted = new ObjectMapper().writeValueAsString(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return converted;
	}
}