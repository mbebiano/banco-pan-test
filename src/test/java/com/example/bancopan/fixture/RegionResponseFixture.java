package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.RegionResponse;

import static br.com.six2six.fixturefactory.Fixture.of;

public class RegionResponseFixture implements TemplateLoader {

    public static final String REGION_RESPONSE = "REGION_RESPONSE";

    @Override
    public void load() {

        of(RegionResponse.class).addTemplate(REGION_RESPONSE,
                new Rule() {{

                    add("regionId", "22");
                    add("regionAcronym", "MS");
                    add("name", "Microregião");;

                }});
    }

}