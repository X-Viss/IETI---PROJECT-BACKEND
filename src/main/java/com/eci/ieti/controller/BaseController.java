package com.eci.ieti.controller;

import com.eci.ieti.model.Question;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Store;

import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import com.eci.ieti.services.TravelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bag")
public class BaseController {

    @Autowired
    private TravelService travelService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/faq")
    public List<Question> getFAQ(){

        return travelService.getFAQ();
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/stores")
    public List<Store> getStores(@RequestParam("category") String category){
        System.out.println(category);
        return travelService.getStores(category);
        
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/travel")
    public Travel getTravel(@RequestParam("travelId") String travelId){
        return travelService.getTravel(travelId);
        
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/newCategory")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putNewCategory(@RequestBody List<GeneritToUserRolWeatherOrCategory> others, @RequestParam("travelId") String travelId) {
        travelService.updateTravelCategory(others, travelId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
