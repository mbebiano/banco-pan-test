package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.dto.StateDTO;

import static br.com.six2six.fixturefactory.Fixture.of;

public class StateDTOFixture implements TemplateLoader {

    public static final String STATE_DTO = "STATE_DTO";
    public static final String STATE_DTO_RJ = "STATE_DTO_RJ";
    public static final String STATE_DTO_SP = "STATE_DTO_SP";

    @Override
    public void load() {

        of(StateDTO.class).addTemplate(STATE_DTO,
                new Rule() {{

                    add("acronym", "MG");
                    add("name", "Minas Gerais");

                }});

        of(StateDTO.class).addTemplate(STATE_DTO_RJ,
                new Rule() {{

                    add("acronym", "RJ");
                    add("name", "Rio de Janeiro");

                }});

        of(StateDTO.class).addTemplate(STATE_DTO_SP,
                new Rule() {{

                    add("acronym", "SP");
                    add("name", "São Paulo");

                }});

    }

}