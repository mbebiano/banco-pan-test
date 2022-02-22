package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.ClientResponse;
import com.example.bancopan.dto.AddressDTO;

import static br.com.six2six.fixturefactory.Fixture.of;

public class ClientResponseFixture implements TemplateLoader {

    public static final String CLIENT_RESPONSE = "CLIENT_RESPONSE";

    @Override
    public void load() {

        of(ClientResponse.class).addTemplate(CLIENT_RESPONSE,
                new Rule() {{

                    add("document", "53313289037");
                    add("firstName", "Mattheus");
                    add("lastName", "Macedo");
                    add("email", "mattheus.bebiano@engenharia.ufjf.br");
                    add("address", one(AddressDTO.class, AddressDTOFixture.ADDRESS_DTO));

                }});
    }

}
