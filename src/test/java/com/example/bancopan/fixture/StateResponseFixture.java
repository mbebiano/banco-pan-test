package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.StateResponse;

import static br.com.six2six.fixturefactory.Fixture.of;

public class StateResponseFixture implements TemplateLoader {

    public static final String STATE_RESPONSE = "STATE_RESPONSE";
    public static final String STATE_RESPONSE_RJ = "STATE_RESPONSE_RJ";
    public static final String STATE_RESPONSE_SP = "STATE_RESPONSE_RJ";

    @Override
    public void load() {

        of(StateResponse.class).addTemplate(STATE_RESPONSE,
                new Rule() {{

                    add("acronym", "MG");
                    add("name", "Minas Gerais");

                }});

        of(StateResponse.class).addTemplate(STATE_RESPONSE_RJ,
                new Rule() {{

                    add("acronym", "RJ");
                    add("name", "Rio de Janeiro");

                }});

        of(StateResponse.class).addTemplate(STATE_RESPONSE_SP,
                new Rule() {{

                    add("acronym", "SP");
                    add("name", "São Paulo");

                }});

    }

}