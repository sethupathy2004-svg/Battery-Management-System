package com.bms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BatteryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double voltage;

    private LocalDateTime timestamp;

    @ManyToOne
    private Battery battery;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}
