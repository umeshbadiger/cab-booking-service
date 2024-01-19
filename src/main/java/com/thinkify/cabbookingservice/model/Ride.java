package com.thinkify.cabbookingservice.model;

import org.springframework.stereotype.Component;

@Component
public class Ride {
    private Long rideId;
    private User user;
    private Driver driver;
    private Location source;
    private Location destination;

    public Ride(){

    }

    public Ride(Long rideId, User user, Driver driver, Location source, Location destination) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideId=" + rideId +
                ", user=" + user +
                ", driver=" + driver +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
