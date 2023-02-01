package com.umlimi.drones.domain.enums;

import javax.persistence.Embeddable;

/**
 * @author MUNASHE MURIMI
 * @created 25/1/2023
 **/
public enum State {
    IDLE,
    LOADING,
    LOADED,
    DELIVERING,
    DELIVERED,
    RETURNING
}
