package com.bms.repository;

import com.bms.model.BatteryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatteryDataRepository
        extends JpaRepository<BatteryData, Integer> {

    List<BatteryData> findByBattery_Id(int batteryId);
}
