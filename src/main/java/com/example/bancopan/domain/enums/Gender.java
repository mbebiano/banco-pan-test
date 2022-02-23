package com.example.bancopan.domain.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum Gender {

    MALE,
    FEMALE;

    public static Map<String, Gender> typeMapping = new HashMap<>();
    static {
        Arrays.asList(Gender.values()).forEach(enumItem -> {
            typeMapping.put(enumItem.toString().toUpperCase(), enumItem);
        });
    }
    public static Gender getEnum(String enumItem) {
        if (StringUtils.isBlank(enumItem) || typeMapping.get(enumItem.toUpperCase()) == null) {
            return null;
        } else {
            return typeMapping.get(enumItem.toUpperCase());
        }
    }
}
