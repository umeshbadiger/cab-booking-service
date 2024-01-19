package com.thinkify.cabbookingservice.repository;

import com.thinkify.cabbookingservice.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DriverRepository {
    List<Driver> driverList = new ArrayList<>();
    public Driver addDriver(Driver newDriverObj) {
        driverList.add(newDriverObj);
        return  newDriverObj;
    }

    public Driver findByDriverId(Long driverId){
        Driver driver = driverList.stream()
                .filter(drirverObj -> drirverObj.getDriverId().equals(driverId))
                .findFirst()
                .orElse(null);
        return driver;
    }

    public int getDriversCount() {
        return driverList.size();
    }

    public List<Driver> getAllDriversList() {
        return new ArrayList<>(driverList);
    }
}
