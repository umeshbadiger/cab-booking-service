package com.thinkify.cabbookingservice.service;

import com.thinkify.cabbookingservice.exception.RidesNotFoundException;
import com.thinkify.cabbookingservice.model.*;
import com.thinkify.cabbookingservice.repository.DriverRepository;
import com.thinkify.cabbookingservice.repository.RideRepository;
import com.thinkify.cabbookingservice.repository.UserRepository;
import com.thinkify.cabbookingservice.util.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RideService {

    @Autowired
    RideRepository rideRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DriverRepository driverRepository;

    public ResponseEntity<Map<String, List<Ride>>> findRide(RideDto rideDetails) {
        ResponseEntity responseEntity = null;
        Map<String, List<Ride>> ridesMap = null;
        try {
            User userDetails = userRepository.findByUserName(rideDetails.getUserName());
            Location sourceLocation = rideDetails.getSourceLocation();
            Location destinatioLocation = rideDetails.getDestinationLocation();

            List<Driver> driverList = driverRepository.getAllDriversList();

            if(driverList != null && !driverList.isEmpty()){
                ridesMap = getAvailableRides(userDetails, sourceLocation, destinatioLocation, driverList);
            } else {
                throw new RidesNotFoundException("Cabs not Available");
            }

        } catch (RidesNotFoundException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(ridesMap, HttpStatus.OK);
//        responseEntity = new ResponseEntity<>(newUser, HttpStatus.OK);
//        responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<Ride>> getAvailableRides(User userDetails, Location sourceLocation,
                                         Location destinatioLocation, List<Driver> driverList) {
        List<Ride> ridesList = new ArrayList<>();
        Map<String, List<Ride>> rideMap = new HashMap<>();

        String userName = userDetails.getName();

        // check for available rides
        for(Driver driver : driverList) {
            double x1 = sourceLocation.getLatitude();
            double y1 = sourceLocation.getLongitude();
            double x2 = driver.getCurrentLocation().getLatitude();
            double y2 = driver.getCurrentLocation().getLongitude();

            double distance = Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );

            System.out.println("distance: "+ distance   );
            if(distance <= 5) {
                Long rideId = SequenceIdGenerator.generateId(ridesList.size());
                User userObj = userRepository.findByUserId(userDetails.getUserId());
                ridesList.add(new Ride(rideId, userObj, driver, sourceLocation, destinatioLocation));
            }
        }

        if(!ridesList.isEmpty()) {
            rideMap.put(userName, ridesList);
        }

        return rideMap;
    }
}
