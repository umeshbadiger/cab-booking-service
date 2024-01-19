package com.thinkify.cabbookingservice.controller;

import com.thinkify.cabbookingservice.model.*;
import com.thinkify.cabbookingservice.service.DriverService;
import com.thinkify.cabbookingservice.service.RideService;
import com.thinkify.cabbookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cab")
public class CabBookingController {

    @Autowired
    private RideService rideService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;


    @Bean
    public void demoRide() {
//        CabBookingController cabController = new CabBookingController();

        // Onboard 3 users
        addUser(new UserDto("Abhishek", "M", 23));
        addUser(new UserDto("Rahul", "M", 29));
        addUser(new UserDto("Nandini", "F", 22));

        // Onboard 3 drivers
        addDriver(new DriverDto("Driver1", "M", 22, new VehicleDto("Kia", "KA-01-12345"), new Location(10, 1), true));
        addDriver(new DriverDto("Driver2", "M", 29, new VehicleDto("Tesla", "KA-01-12345"), new Location(11, 10), true));
        addDriver(new DriverDto("Driver3", "M", 24, new VehicleDto("Swift", "KA-01-12345"), new Location(5, 3), false));


        // User trying to get a ride
        Map<String, List<Ride>> result1 = findRide(new RideDto("Abhishek", new Location(0, 0), new Location(20, 1)));
        if(!result1.isEmpty() || result1 != null)
            result1.forEach((k,v) -> System.out.println("Ride found for user" +k+" : "+ v));
        else
            System.out.println("No ride found");
        // User searching for a ride
        Map<String, List<Ride>> result2 = findRide(new RideDto("Rahul", new Location(10, 0), new Location(15, 3)));
        if(!result2.isEmpty() || result2 != null){
            result1.forEach((k,v) -> System.out.println("Ride found: "+ k +" : "+ v));
        }
        else
            System.out.println("No ride found");

        // User trying to get a ride
        Map<String, List<Ride>> result3=  findRide(new RideDto("Nandini", new Location(15, 6), new Location(20, 4)));
        if(!result3.isEmpty() || result3 != null)
            result1.forEach((k,v) -> System.out.println(k +" : "+ v));
        else
            System.out.println("No ride found");
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDetails) {

        ResponseEntity responseEntity = userService.addUser(userDetails);

        return responseEntity;
    }

    @PostMapping("/driver")
    public ResponseEntity<?> addDriver(@RequestBody DriverDto driverDetails) {
        ResponseEntity responseEntity = driverService.addDriver(driverDetails);
        return responseEntity;
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUsers(){
        demoRide();
        System.out.println("mehtod Executed");
        ResponseEntity<List<User>> responseEntity = userService.getAllUsers();

        List<User> userList = responseEntity.getBody();
        System.out.println("User List Size: "+ userList.size());
        userList.forEach(u-> System.out.println(u));
        return responseEntity;
    }

    @GetMapping("/get-all-drivers")
    public ResponseEntity<?> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PostMapping("/find-ride")
    public Map<String, List<Ride>> findRide(@RequestBody RideDto rideDetails ) {
//        System.out.println("find-ride method :: entered");
        ResponseEntity<Map<String, List<Ride>>> responseEntity = rideService.findRide(rideDetails);
        Map<String, List<Ride>> rideDetailsMap = responseEntity.getBody();

        rideDetailsMap.forEach((k, v)-> System.out.println("key: "+ k +" value: "+v));

        return rideDetailsMap;
    }

//    @PostMapping("/choose-ride")
//    public String chooseRide(@RequestParam String username, @RequestParam String driverName) {
//        String result = rideService.chooseRide(username, driverName);
//        return result;
//    }

}
