package com.umlimi.drones.utils;

import com.umlimi.drones.exceptionhandling.InvalidInputParameterException;

/**
 * @author MUNASHE MURIMI
 * @created 29/1/2023
 **/
public class Validations {
    public static boolean validateName(String name){
        String pattern = "^[a-zA-Z0-9-_]+$";
        if(!name.matches(pattern)){
            throw new InvalidInputParameterException(String.format(
                    "Invalid name %s . Only names with letters, numbers, underscores and hyphens are allowed",
                    name));
        }
        return name.matches(pattern);
    }

    public static boolean validateCode(String code) {
        String pattern = "^[A-Z0-9_]+$";
        if(!code.matches(pattern)){
            throw new InvalidInputParameterException(String.format("Invalid code %s. Ony uppercase letters," +
                    "underscore and numbers are allowed", code));
        }
        return code.matches(pattern);
    }
}
