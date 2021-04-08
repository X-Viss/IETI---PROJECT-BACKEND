package com.eci.ieti.services;

import com.eci.ieti.persistence.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatServices {
  @Autowired TripRepository tripRepository;

  public Map<String, Integer> getAmountTrips() {
    Map<String, Integer> countTrips = new HashMap<>();
    tripRepository
        .findAll()
        .forEach(
            trip -> {
              if (countTrips.containsKey(trip.getNametrip()))
                countTrips.put(trip.getNametrip(), countTrips.get(trip.getNametrip()) + 1);
              else countTrips.put(trip.getNametrip(), 1);
            });
    return countTrips;
  }
}
