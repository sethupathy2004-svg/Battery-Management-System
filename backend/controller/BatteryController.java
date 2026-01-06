package com.bms.controller;

import com.bms.model.Battery;
import com.bms.model.BatteryData;
import com.bms.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/add")
    public Battery addBattery(@RequestBody Battery battery) {
        return batteryService.addBattery(battery);
    }

    @PostMapping("/{batteryId}/data")
    public BatteryData addBatteryData(@PathVariable int batteryId,
                                      @RequestBody BatteryData data) {
        return batteryService.saveBatteryData(batteryId, data);
    }

    @GetMapping("/{batteryId}/data")
    public List<BatteryData> getBatteryData(@PathVariable int batteryId) {
        return batteryService.getBatteryData(batteryId);
    }
}
