package com.bms.service;

import org.springframework.stereotype.Service;

@Service
public class BatteryService {

    public double calculateSOC(double voltage, double ratedVoltage) {
        return (voltage / ratedVoltage) * 100;
    }
}
