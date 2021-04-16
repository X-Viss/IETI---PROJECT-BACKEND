
package com.eci.ieti.controller;

import com.eci.ieti.model.Travel;
import com.eci.ieti.services.TravelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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
}