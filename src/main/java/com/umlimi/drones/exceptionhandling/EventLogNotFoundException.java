package com.umlimi.drones.exceptionhandling;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class EventLogNotFoundException extends RuntimeException{
    public EventLogNotFoundException(String message){
        super(message);
    }
}
