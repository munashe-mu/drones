package com.umlimi.drones.persistence;

import com.umlimi.drones.domain.Drone;
import com.umlimi.drones.domain.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findAllByState(State state);
    Optional<Drone> findBySerialNumber(String serialNumber);

}
