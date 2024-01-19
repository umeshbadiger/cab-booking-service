package com.thinkify.cabbookingservice.model;

public class RideDto {
    private Long rideId;
    private String userName;
    private Location sourceLocation;
    private Location destinationLocation;

    public RideDto(String userName, Location sourceLocation, Location destinationLocation) {
        this.userName = userName;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
