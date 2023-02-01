package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class DroneNotFoundException extends RuntimeException{
    public DroneNotFoundException(String message){
        super(message);
    }
}
