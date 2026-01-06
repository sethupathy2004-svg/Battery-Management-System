package com.bms.controller;

import com.bms.model.Battery;
import com.bms.model.BatteryData;
import com.bms.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battery")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;
    @PostMapping("/add")
    public Battery addBattery(@RequestBody Battery battery) {
        return batteryService.saveBattery(battery);
    }

    @GetMapping("/all")
    public List<Battery> getAllBatteries() {
        return batteryService.getAllBatteries();
    }

    @GetMapping("/soc")
    public double getSOC(@RequestParam double voltage,
                         @RequestParam double ratedVoltage) {
        return batteryService.calculateSOC(voltage, ratedVoltage);
    }
}
