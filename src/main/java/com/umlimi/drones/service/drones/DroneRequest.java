package com.umlimi.drones.service.drones;

import com.umlimi.drones.domain.enums.Model;
import com.umlimi.drones.domain.enums.State;
import lombok.Data;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
@Data
public class DroneRequest {
    private String serialNumber;
    private Model model;
    private Integer weightLimit;
    private Integer batteryCapacity;
    private State state;
}
