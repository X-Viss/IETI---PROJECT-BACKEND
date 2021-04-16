package com.eci.ieti.controller;


import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import com.eci.ieti.services.TravelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/bag")
public class BaseController {

    @Autowired
    private TravelService travelService;
    
    @GetMapping("/travel")
    public Travel getTravel(@RequestParam("travelId") String travelId){
        return travelService.getTravel(travelId);
        
    }

    @PutMapping(value = "category/newCategory")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putNewCategory(@RequestBody List<GeneritToUserRolWeatherOrCategory> others, @RequestParam("travelId") String travelId) {
        travelService.updateTravelCategory(others, travelId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}