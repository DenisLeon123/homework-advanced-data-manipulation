package com.sample.hotel.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "ROOM")
@Entity
public class Room {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    private Integer number;

    @Column(name = "FLOOR_")
    private Integer floor;

    @Column(name = "SQUARE_METERS")
    private Integer squareMeters;

    @NotNull
    @Column(name = "SLEEPING_PLACES", nullable = false)
    private Integer sleepingPlaces;

    @Column(name = "SAFE_DEPOSIT")
    private Boolean safeDeposit;

    @Column(name = "NICE_VIEW_FROM_WINDOW")
    private Boolean niceViewFromWindow;

    @Column(name = "QUIET")
    private Boolean quiet;

    @Column(name = "MINIBAR")
    private Boolean minibar;

    @Column(name = "AIR_CONDITIONER")
    private Boolean airConditioner;

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Boolean getMinibar() {
        return minibar;
    }

    public void setMinibar(Boolean minibar) {
        this.minibar = minibar;
    }

    public Boolean getQuiet() {
        return quiet;
    }

    public void setQuiet(Boolean quiet) {
        this.quiet = quiet;
    }

    public Boolean getNiceViewFromWindow() {
        return niceViewFromWindow;
    }

    public void setNiceViewFromWindow(Boolean niceViewFromWindow) {
        this.niceViewFromWindow = niceViewFromWindow;
    }

    public Boolean getSafeDeposit() {
        return safeDeposit;
    }

    public void setSafeDeposit(Boolean safeDeposit) {
        this.safeDeposit = safeDeposit;
    }

    public Integer getSleepingPlaces() {
        return sleepingPlaces;
    }

    public void setSleepingPlaces(Integer sleepingPlaces) {
        this.sleepingPlaces = sleepingPlaces;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}