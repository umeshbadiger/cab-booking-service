package com.thinkify.cabbookingservice.model;

public class DriverDto {
    private Long driverId;
    private String name;
    private String gender;
    private int age;
    private VehicleDto vehicleDetails;
    private Location currentLocation;
    private boolean isAvailable;

    public DriverDto(Long driverId, String name, String gender, int age, VehicleDto vehicleDetails, Location currentLocation, boolean isAvailable) {
        this.driverId = driverId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.isAvailable = isAvailable;
    }

    public DriverDto( String name, String gender, int age, VehicleDto vehicleDetails, Location currentLocation, boolean isAvailable) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.isAvailable = isAvailable;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public VehicleDto getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDto vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
