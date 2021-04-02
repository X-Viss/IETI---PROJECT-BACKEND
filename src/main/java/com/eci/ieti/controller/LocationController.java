package com.eci.ieti.controller;

import com.eci.ieti.model.Location;
import com.eci.ieti.services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Locations")
public class LocationController {
  @Autowired LocationServices locationServices;

  @GetMapping
  public List<Location> locationList() {
    return locationServices.getAllLocations();
  }

  @GetMapping("/{namesite}")
  public Location getLocation(@PathVariable String namesite) {
    return locationServices.getFindByLocation(namesite);
  }
}
