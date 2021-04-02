package com.eci.ieti.services;

import com.eci.ieti.model.Location;
import com.eci.ieti.persistence.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServices {

  @Autowired LocationRepository locationRepository;

  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }

  public Location getFindByLocation(String id) {
    return locationRepository.findById(id).orElse(Location.builder().build());
  }
}
