package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.domain.enums.State;
import com.example.bancopan.dto.AddressDTO;

import static br.com.six2six.fixturefactory.Fixture.of;

public class AddressDTOFixture implements TemplateLoader {

    public static final String ADDRESS_DTO = "ADDRESS_DTO";

    @Override
    public void load() {

        of(AddressDTO.class).addTemplate(ADDRESS_DTO,
                new Rule() {{

                    add("zipcode", "36047100");
                    add("street", "Rua Aurora Tristao");
                    add("number", "S/N");
                    add("city", "Juiz de Fora");
                    add("state", State.MG);

                }});
    }

}