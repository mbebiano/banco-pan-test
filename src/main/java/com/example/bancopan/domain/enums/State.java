package com.example.bancopan.domain.enums;

import com.example.bancopan.exceptions.StateNotFoundException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum State {
    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private String description;
    public static Map<String, State> typeMapping = new HashMap<>();

    private State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static State getEnum(String enumItem) {
        if (!StringUtils.isBlank(enumItem) && typeMapping.get(enumItem.toUpperCase()) != null) {
            return (State)typeMapping.get(enumItem.toUpperCase());
        } else {
            throw new StateNotFoundException(String.format("There is no State with name (%s)", enumItem));
        }
    }

    static {
        Arrays.asList(values()).forEach((enumItem) -> {
            typeMapping.put(enumItem.toString(), enumItem);
        });
    }
}
