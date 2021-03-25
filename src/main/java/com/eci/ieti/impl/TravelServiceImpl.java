package com.eci.ieti.impl;

import com.eci.ieti.TravelService;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Travel;
import com.eci.ieti.persistence.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {


    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Travel> getUserTravels(String user) throws TravelException {
        return travelRepository.getUserTravels(user);
    }
}
