//package com.umlimi.drones.service.drones.scheduler;
//
//import com.umlimi.drones.domain.EventLogs;
//import com.umlimi.drones.persistence.DroneRepository;
//import com.umlimi.drones.persistence.EventLogRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
///**
// * @author MUNASHE MURIMI
// * @created 31/1/2023
// **/
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class DroneScheduler {
//    private final DroneRepository droneRepository;
//    private final EventLogRepository eventLogRepository;
//
//    @Scheduled(fixedDelay = 600000)
//    public void checkDroneBattery(){
//        log.info("Inside cron job........");
//        droneRepository.findAll()
//                .stream()
//                .forEach(drone -> {
//                    EventLogs eventLogs = new EventLogs();
//                    log.info("Checking battery capacity for drone with id = {}, serialNumber = {}",
//                            drone.getDroneId(), drone.getSerialNumber());
//                    eventLogs.setDroneId(drone.getDroneId());
//                    eventLogs.setBatteryCapacity(drone.getBatteryCapacity());
//                    eventLogs.setState(drone.getState());
//                    eventLogs.setSerialNumber(drone.getSerialNumber());
//                    eventLogs.setCreatedDate(LocalDate.now());
//                    eventLogRepository.save(eventLogs);
//                });
//    }
//}
