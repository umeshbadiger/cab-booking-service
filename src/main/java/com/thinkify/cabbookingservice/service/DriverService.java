package com.thinkify.cabbookingservice.service;

import com.thinkify.cabbookingservice.exception.UserAlreadyExistsException;
import com.thinkify.cabbookingservice.model.*;
import com.thinkify.cabbookingservice.repository.DriverRepository;
import com.thinkify.cabbookingservice.util.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepo;
    public ResponseEntity<?> addDriver(DriverDto driverDetails) {

            ResponseEntity<?> responseEntity;
            try{
                Long driverId = null;
                Driver driverObj = null;
                Driver newDriver = null;

                if(driverDetails.getDriverId() != null){
                    driverId = driverDetails.getDriverId();
                    driverObj = driverRepo.findByDriverId(driverId);
                }

                if(driverObj == null) {
                    Driver newDriverObj = getDriverObj(driverDetails);
                    newDriver = driverRepo.addDriver(newDriverObj);
                    responseEntity = new ResponseEntity<>(newDriver, HttpStatus.OK);
                } else {
                    throw new UserAlreadyExistsException("Driver with Id: "+ driverDetails.getDriverId() +" already Exists");

                }
            }catch (UserAlreadyExistsException exception){
                exception.printStackTrace();
                responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
            }

            return responseEntity;
    }

    Driver getDriverObj(DriverDto driverDetails){
        Long driverId = null;
        if(driverDetails.getDriverId() != null) {
            driverId = driverDetails.getDriverId();
        } else {
            driverId = SequenceIdGenerator.generateId(driverRepo.getDriversCount());
        }

        String name = driverDetails.getName();
        String gender = driverDetails.getGender();
        int age = driverDetails.getAge();

        Location driverLocation = new Location(driverDetails.getCurrentLocation().getLatitude(),driverDetails.getCurrentLocation().getLongitude() );

        VehicleDto vehicle = driverDetails.getVehicleDetails();
        Cab cabDetails = new Cab(vehicle.getModelName(),vehicle.getVehicleNo());

        boolean isAvailable = driverDetails.isAvailable();

        return new Driver(driverId,name,gender,age,cabDetails,driverLocation,isAvailable);
    }

    public ResponseEntity<List<Driver>> getAllDrivers() {
        ResponseEntity responseEntity = null;
        List<Driver> driverList = null;
        try{
            driverList = driverRepo.getAllDriversList();

        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<Driver>>(driverList, HttpStatus.OK);
    }
}
