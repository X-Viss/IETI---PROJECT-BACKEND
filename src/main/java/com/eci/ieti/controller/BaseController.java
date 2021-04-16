package com.eci.ieti.controller;

import com.eci.ieti.model.Store;
import com.eci.ieti.services.TravelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/bag")
public class BaseController {

    @Autowired
    private TravelService travelService;
    
    @GetMapping("/stores")
    public List<Store> getStores(@RequestParam("category") String category){
        return travelService.getStores(category);
        
    }
}