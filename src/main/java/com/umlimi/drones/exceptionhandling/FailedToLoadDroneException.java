package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class FailedToLoadDroneException extends RuntimeException{
    public FailedToLoadDroneException(String message){
        super(message);
    }
}
