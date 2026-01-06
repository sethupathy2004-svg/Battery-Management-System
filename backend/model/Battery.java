package com.bms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "battery_data")
public class BatteryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dataId;

    @ManyToOne
    @JoinColumn(name = "battery_id")
    private Battery battery;

    private double voltage;
    private double current;
    private double temperature;
    private double soc;

    private LocalDateTime timestamp;

    // Getters and Setters
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSoc() {
        return soc;
    }

    public void setSoc(double soc) {
        this.soc = soc;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
