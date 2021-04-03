package com.eci.ieti.controller;


import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping
    public ResponseEntity<Object> getTravels(@RequestParam("user") String user){
        try {
            return new ResponseEntity<>(travelService.getUserTravels(user), HttpStatus.OK);
        } catch (TravelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping
    public ResponseEntity<Object> deleteTravel(@RequestParam("travelId") long travelId){
        try {
            return new ResponseEntity<>(travelService.deleteTravelById(travelId), HttpStatus.OK);
        } catch (TravelException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
