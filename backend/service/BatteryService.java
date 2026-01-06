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

    @Autowired
    private BatteryDataRepository batteryDataRepository;

    public double calculateSOC(double voltage, double ratedVoltage) {
        return (voltage / ratedVoltage) * 100;
    }

    public Battery addBattery(Battery battery) {
        return batteryRepository.save(battery);
    }

    public BatteryData saveBatteryData(int batteryId, BatteryData data) {
        Battery battery = batteryRepository.findById(batteryId).orElseThrow();
        data.setBattery(battery);
        data.setTimestamp(LocalDateTime.now());
        return batteryDataRepository.save(data);
    }

    public List<BatteryData> getBatteryData(int batteryId) {
        return batteryDataRepository.findByBattery_BatteryId(batteryId);
    }
}
