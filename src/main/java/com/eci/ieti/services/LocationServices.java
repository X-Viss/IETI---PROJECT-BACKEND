package com.eci.ieti.services;

import com.eci.ieti.model.Place;
import com.eci.ieti.persistence.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServices {

  @Autowired LocationRepository locationRepository;

  public List<Place> getAllLocations() {
    return locationRepository.findAll();
  }

  public Place getFindByLocation(String id) {
    return locationRepository.findById(id).orElse(Place.builder().build());
  }
}
