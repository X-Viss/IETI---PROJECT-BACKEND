package com.eci.ieti.controller;

import com.eci.ieti.model.Question;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.services.TravelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/bag")
public class BaseController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/faq")
    public List<Question> getFAQ(){

        return travelService.getFAQ();
    }
}
