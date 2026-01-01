package com.bms.controller;

import com.bms.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battery")
@CrossOrigin
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @GetMapping("/soc")
    public double getSOC(@RequestParam double voltage,
                         @RequestParam double ratedVoltage) {

        return batteryService.calculateSOC(voltage, ratedVoltage);
    }
}
