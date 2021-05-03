package com.eci.ieti.controller;


import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
            String name  =  SecurityContextHolder.getContext().getAuthentication().getName();
            return new ResponseEntity<>(travelService.getUserTravels(name), HttpStatus.OK);
        } catch (TravelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
