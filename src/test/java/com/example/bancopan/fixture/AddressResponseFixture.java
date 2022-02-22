package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.response.AddressResponse;

import static br.com.six2six.fixturefactory.Fixture.of;

public class AddressResponseFixture implements TemplateLoader {

    public static final String ADDRESS_RESPONSE = "ADDRESS_RESPONSE";

    @Override
    public void load() {

        of(AddressResponse.class).addTemplate(ADDRESS_RESPONSE,
                new Rule() {{

                    add("zipCode", "36047100");
                    add("street", "Rua Aurora Tristao");
                    add("complement", "S/N");
                    add("district", "Bandeirantes");
                    add("city", "Juiz de Fora");
                    add("state", "MG");

                }});
    }

}