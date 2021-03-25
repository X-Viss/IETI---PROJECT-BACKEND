package com.eci.ieti.controller;


import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;


    @GetMapping
    public ResponseEntity<?> getTravels(@RequestParam("user") String user){
        try {
            return new ResponseEntity<>(travelService.getUserTravels(user), HttpStatus.OK);
        } catch (TravelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
