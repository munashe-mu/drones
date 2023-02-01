package com.umlimi.drones.utils;

import com.umlimi.drones.domain.Drone;
import com.umlimi.drones.domain.EventLogs;
import com.umlimi.drones.domain.Medication;
import com.umlimi.drones.service.drones.DroneDto;
import com.umlimi.drones.service.eventlogs.EventLogsDto;
import com.umlimi.drones.service.medication.MedicationDto;
import org.modelmapper.ModelMapper;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public class EntityToDtoMapper {
    public static DroneDto convertToDroneDto(Drone drone, ModelMapper modelMapper){
        DroneDto droneDto = modelMapper.map(drone,DroneDto.class);
        return droneDto;
    }

    public static MedicationDto convertMedicationDto(Medication medication, ModelMapper  modelMapper){
        MedicationDto medicationDto = modelMapper.map(medication, MedicationDto.class);
        return medicationDto;
    }

    public static EventLogsDto convertEventLogsDto(EventLogs eventLogs, ModelMapper modelMapper){
        EventLogsDto eventLogsDto = modelMapper.map(eventLogs, EventLogsDto.class);
        return eventLogsDto;
    }
}
