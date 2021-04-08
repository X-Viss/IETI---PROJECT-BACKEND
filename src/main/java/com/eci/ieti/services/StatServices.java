package com.eci.ieti.services;

import com.eci.ieti.model.Trip;
import com.eci.ieti.persistence.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatServices {
  @Autowired TripRepository tripRepository;

  public Map<String, Integer> getAmountTrips() {
    Map<String, Integer> countTrips = new HashMap<>();
    List<String> alltrips =
        tripRepository.findAll().stream().map(Trip::getNametrip).collect(Collectors.toList());

    alltrips.stream()
        .distinct()
        .collect(Collectors.toList())
        .forEach(s -> countTrips.put(s, Collections.frequency(alltrips, s)));

    return countTrips;
  }
}
