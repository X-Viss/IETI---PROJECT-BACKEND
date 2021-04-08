package com.eci.ieti.services;

import com.eci.ieti.model.Trip;
import com.eci.ieti.persistence.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServices {

  @Autowired TripRepository tripRepository;

  public List<Trip> getAllTrips() {
    return tripRepository.findAll();
  }

  public Trip getFindByTrip(String id) {
    return tripRepository.findById(id).orElse(Trip.builder().build());
  }
}
