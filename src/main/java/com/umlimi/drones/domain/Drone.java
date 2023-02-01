package com.umlimi.drones.domain;

import com.umlimi.drones.domain.enums.Model;
import com.umlimi.drones.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author MUNASHE MURIMI
 * @created 25/1/2023
 **/
@Data
@Entity
@Builder
@Table(name = "Drones")
@AllArgsConstructor
@NoArgsConstructor

public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false)
    private Long droneId;
    @Column(length = 100, unique = true)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    private Integer weightLimit;
    private Integer batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private Medication medication;
}
