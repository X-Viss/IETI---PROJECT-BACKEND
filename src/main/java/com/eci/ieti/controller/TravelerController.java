package com.eci.ieti.controller;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.services.TravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/traveler")
public class TravelerController {
    @Autowired
    private TravelService travelService;
    
    @GetMapping
    public ResponseEntity<Object> getTravel(@RequestParam("user") String user,@RequestParam("travel") String travel){
        try {
            return new ResponseEntity<>(travelService.getUserTravels(user), HttpStatus.OK);
        } catch (TravelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
