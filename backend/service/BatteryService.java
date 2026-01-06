package com.bms.service;

import com.bms.model.Battery;
import com.bms.model.BatteryData;
import com.bms.repository.BatteryDataRepository;
import com.bms.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    public Battery saveBattery(Battery battery) {
        return batteryRepository.save(battery);
    }

    public List<Battery> getAllBatteries() {
        return batteryRepository.findAll();
    }

    public double calculateSOC(double voltage, double ratedVoltage) {
        return (voltage / ratedVoltage) * 100;
    }
}
