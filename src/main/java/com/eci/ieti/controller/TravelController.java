package com.eci.ieti.controller;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    /**
     * Return the user travels
     * @param user Name of the user
     * @return List of travels of the user
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Object> getTravels(@RequestParam("user") String user){
        try {
            return new ResponseEntity<>(travelService.getUserTravels(user), HttpStatus.OK);
        } catch (TravelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
