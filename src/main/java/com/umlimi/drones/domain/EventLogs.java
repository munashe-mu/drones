package com.umlimi.drones.domain;

import com.umlimi.drones.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "event_logs")
@Entity
public class EventLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long droneId;
    private String serialNumber;
    private Integer batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate createdDate;
}
