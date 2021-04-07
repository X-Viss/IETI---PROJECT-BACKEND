package com.eci.ieti.controller;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Country;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/create")
public class CreateTripController {

    @Autowired
    private TravelService travelService;

    @PostMapping(value = "rol")
    public ResponseEntity<?> postSelectTravelerRol(@RequestBody List<UserRol> userRolList) {
        return new ResponseEntity<>(travelService.postTravelerRol(userRolList), HttpStatus.CREATED);
    }

    @PutMapping(value = "destiny")
    public ResponseEntity<?> putDestinyByUserRolSelected(@RequestBody Country destiny, @RequestParam("id") String id) {
        System.out.println("llegue qui");
        System.out.println(destiny);
        travelService.putDestinyByUserRolSelected(destiny, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
