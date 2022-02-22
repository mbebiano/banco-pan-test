package com.example.bancopan.fixture;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.example.bancopan.controller.request.AddressChangeRequest;
import com.example.bancopan.controller.request.ClientChangeAddressRequest;

import static br.com.six2six.fixturefactory.Fixture.of;

public class ClientChangeAddressRequestFixture implements TemplateLoader {

    public static final String CLIENT_CHANGE_ADDRESS_REQUEST = "CLIENT_CHANGE_ADDRESS_REQUEST";

    @Override
    public void load() {

        of(ClientChangeAddressRequest.class).addTemplate(CLIENT_CHANGE_ADDRESS_REQUEST,
                new Rule() {{

                    add("document", "53313289037");
                    add("address", one(AddressChangeRequest.class, AddressChangeRequestFixture.ADDRESS_CHANGE_REQUEST));

                }});
    }

}
