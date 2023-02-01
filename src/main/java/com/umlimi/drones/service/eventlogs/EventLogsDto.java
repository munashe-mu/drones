package com.umlimi.drones.service.eventlogs;

import com.umlimi.drones.domain.enums.State;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author MUNASHE MURIMI
 * @created 29/1/2023
 **/
@Data
public class EventLogsDto {
    private Long id;
    private Long droneId;
    private String serialNumber;
    private Integer batteryCapacity;
    private State state;
    private LocalDate dateCreated;
}
