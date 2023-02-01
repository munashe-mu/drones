package com.umlimi.drones.service.medication;

import lombok.Data;

/**
 * @author MUNASHE MURIMI
 * @created 29/1/2023
 **/
@Data
public class MedicationDto {
    private Long id;
    private String name;
    private Integer weight;
    private String code;
    private String image;
}
