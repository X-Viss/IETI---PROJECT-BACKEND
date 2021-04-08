package com.eci.ieti.controller;

import com.eci.ieti.services.StatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Statisctics")
public class StatController {
  @Autowired StatServices statServices;

  @GetMapping
  public Map<String, Integer> getAmountTrips() {
    return statServices.getAmountTrips();
  }
}
