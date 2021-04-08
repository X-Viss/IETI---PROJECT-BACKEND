package com.eci.ieti.controller;

import com.eci.ieti.model.Trip;
import com.eci.ieti.services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Trips")
public class TripController {
  @Autowired TripServices tripServices;

  @GetMapping
  public List<Trip> tripsList() {
    return tripServices.getAllTrips();
  }

  @GetMapping("/{nametrip}")
  public List<Trip> getTypeTrip(@PathVariable String nametrip) {
    return tripServices.getFindByTrip(nametrip);
  }

}
