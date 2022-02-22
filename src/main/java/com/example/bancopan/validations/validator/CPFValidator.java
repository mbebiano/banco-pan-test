package com.example.bancopan.validations.validator;

import com.example.bancopan.exceptions.CPFNotValidException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CPFValidator {

    private static final int[] CPF_WEIGHT = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public String isValidatedCPF(String document){
        if (!isValidCPF(document)){
            throw new CPFNotValidException("Invalid document");
        }
        return document;
    }

    private static boolean isValidCPF(String document) {
        if ((Objects.isNull(document)) || (document.length() != 11)) {
            return false;
        }

        Integer digit1 = calculate(document.substring(0,9), CPF_WEIGHT);
        Integer digit2 = calculate(document.substring(0,9) + digit1, CPF_WEIGHT);
        return document.equals(document.substring(0,9) + digit1.toString() + digit2.toString());
    }

    private static int calculate(String str, int[] weight) {
        int sum = 0;
        for (int i = str.length()-1, digit; i >= 0; i-- ) {
            digit = Integer.parseInt(str.substring(i,i+1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

}
