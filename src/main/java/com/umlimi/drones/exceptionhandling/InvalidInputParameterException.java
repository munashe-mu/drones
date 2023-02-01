package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class InvalidInputParameterException extends RuntimeException{
    public InvalidInputParameterException(String message){
        super(message);
    }
}
