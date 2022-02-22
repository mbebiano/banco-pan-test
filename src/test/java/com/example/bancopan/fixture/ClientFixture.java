package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.Client;
import com.example.bancopan.domain.Gender;

import static br.com.six2six.fixturefactory.Fixture.of;

public class ClientFixture implements TemplateLoader {

    public static final String CLIENT = "CLIENT";

    @Override
    public void load() {

        of(Client.class).addTemplate(CLIENT,
                new Rule() {{

                    add("document", "53313289037");
                    add("firstName", "Mattheus");
                    add("lastName", "Macedo");
                    add("email", "mattheus.bebiano@engenharia.ufjf.br");
                    add("gender", Gender.MALE);
                    add("address", one(Address.class, AddressFixture.ADDRESS));

                }});
    }

}
