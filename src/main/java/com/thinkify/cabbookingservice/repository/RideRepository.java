package com.thinkify.cabbookingservice.repository;

import com.thinkify.cabbookingservice.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RideRepository {

    private List<Ride> rideList = new ArrayList<>();

}
