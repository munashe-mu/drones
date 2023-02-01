package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class MedicationNotFoundException extends RuntimeException{
    public MedicationNotFoundException(String message){
        super(message);
    }
}
