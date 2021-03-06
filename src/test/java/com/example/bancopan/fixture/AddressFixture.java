package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.domain.Address;
import com.example.bancopan.domain.enums.State;

import static br.com.six2six.fixturefactory.Fixture.of;

public class AddressFixture implements TemplateLoader {

    public static final String ADDRESS = "ADDRESS";

    @Override
    public void load() {

        of(Address.class).addTemplate(ADDRESS,
                new Rule() {{

                    add("zipcode", "36047100");
                    add("street", "Rua Aurora Tristao");
                    add("number", "S/N");
                    add("city", "Juiz de Fora");
                    add("state", State.MG);

                }});
    }

}