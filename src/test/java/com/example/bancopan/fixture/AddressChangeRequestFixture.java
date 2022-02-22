package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.request.AddressChangeRequest;
import com.example.bancopan.domain.State;

import static br.com.six2six.fixturefactory.Fixture.of;

public class AddressChangeRequestFixture implements TemplateLoader {

    public static final String ADDRESS_CHANGE_REQUEST = "ADDRESS_CHANGE_REQUEST";

    @Override
    public void load() {

        of(AddressChangeRequest.class).addTemplate(ADDRESS_CHANGE_REQUEST,
                new Rule() {{

                    add("zipcode", "36047100");
                    add("street", "Rua Aurora Tristao");
                    add("number", "S/N");
                    add("city", "Juiz de Fora");
                    add("state", State.MG);

                }});
    }

}