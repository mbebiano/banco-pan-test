package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.CityResponse;

import static br.com.six2six.fixturefactory.Fixture.of;

public class CityResponseFixture implements TemplateLoader {

    public static final String CITIES_RESPONSE = "CITIES_RESPONSE";

    @Override
    public void load() {

        of(CityResponse.class).addTemplate(CITIES_RESPONSE,
                new Rule() {{

                    add("id", "11");
                    add("name", "Juiz de Fora");

                }});
    }

}
