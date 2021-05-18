package com.eci.ieti.controller;

import com.eci.ieti.model.Trip;
import com.eci.ieti.services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Trips")
public class TripController {
  @Autowired TripServices tripServices;

  @CrossOrigin(origins = "*")
  @GetMapping
  public List<Trip> tripsList() {
    return tripServices.getAllTrips();
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/{nametrip}")
  public List<Trip> getTypeTrip(@PathVariable String nametrip) {
    return tripServices.getFindByTrip(nametrip);
  }

}
