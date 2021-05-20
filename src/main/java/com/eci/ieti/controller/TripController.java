package com.eci.ieti.controller;

import com.eci.ieti.model.Trip;
import com.eci.ieti.services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Trips")
public class TripController {
  @Autowired TripServices tripServices;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<Trip> tripsList() {
    return tripServices.getAllTrips();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("/{nametrip}")
  public List<Trip> getTypeTrip(@PathVariable String nametrip) {
    return tripServices.getFindByTrip(nametrip);
  }

}
