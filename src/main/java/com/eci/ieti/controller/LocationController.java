package com.eci.ieti.controller;

import com.eci.ieti.model.Place;
import com.eci.ieti.services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Locations")
public class LocationController {
  @Autowired LocationServices locationServices;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<Place> locationList() {
    return locationServices.getAllLocations();
  }


  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("/{namesite}")
  public Place getLocation(@PathVariable String namesite) {
    return locationServices.getFindByLocation(namesite);
  }
}
