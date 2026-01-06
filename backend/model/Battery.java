package com.bms.model;

import jakarta.persistence.*;

@Entity
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double voltage;
    private double ratedVoltage;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVoltage() {
        return voltage;
    }
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setRatedVoltage(double ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }
    public double getRatedVoltage() {
        return ratedVoltage;
    }

   
}
