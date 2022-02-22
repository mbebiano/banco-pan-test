package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.dto.AddressDTO;
import com.example.bancopan.dto.ClientDTO;

import static br.com.six2six.fixturefactory.Fixture.of;

public class ClientDTOFixture implements TemplateLoader {

    public static final String CLIENT_DTO = "CLIENT_DTO";

    @Override
    public void load() {

        of(ClientDTO.class).addTemplate(CLIENT_DTO,
                new Rule() {{

                    add("document", "53313289037");
                    add("firstName", "Mattheus");
                    add("lastName", "Macedo");
                    add("email", "mattheus.bebiano@engenharia.ufjf.br");
                    add("addressDTO", one(AddressDTO.class, AddressDTOFixture.ADDRESS_DTO));

                }});
    }

}
