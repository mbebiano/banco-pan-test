package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.RegionResponse;
import com.example.bancopan.controller.response.StateIBGEResponse;

import static br.com.six2six.fixturefactory.Fixture.of;

public class StateIBGEResponseFixture implements TemplateLoader {

    public static final String STATE_IBGE_RESPONSE = "STATE_IBGE_RESPONSE";
    public static final String STATE_IBGE_RESPONSE_RJ = "STATE_IBGE_RESPONSE_RJ";
    public static final String STATE_IBGE_RESPONSE_SP = "STATE_IBGE_RESPONSE_SP";

    @Override
    public void load() {

        of(StateIBGEResponse.class).addTemplate(STATE_IBGE_RESPONSE,
                new Rule() {{

                    add("stateId", "11");
                    add("acronym", "MG");
                    add("name", "Minas Gerais");
                    add("region", one(RegionResponse.class, RegionResponseFixture.REGION_RESPONSE));

                }});

        of(StateIBGEResponse.class).addTemplate(STATE_IBGE_RESPONSE_RJ,
                new Rule() {{

                    add("stateId", "12");
                    add("acronym", "RJ");
                    add("name", "Rio de Janeiro");
                    add("region", one(RegionResponse.class, RegionResponseFixture.REGION_RESPONSE));

                }});

        of(StateIBGEResponse.class).addTemplate(STATE_IBGE_RESPONSE_SP,
                new Rule() {{

                    add("stateId", "12");
                    add("acronym", "SP");
                    add("name", "São Paulo");
                    add("region", one(RegionResponse.class, RegionResponseFixture.REGION_RESPONSE));

                }});
    }

}