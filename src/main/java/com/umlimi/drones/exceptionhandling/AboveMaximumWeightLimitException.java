package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class AboveMaximumWeightLimitException extends RuntimeException{
    public AboveMaximumWeightLimitException(String message){
        super(message);
    }

}
