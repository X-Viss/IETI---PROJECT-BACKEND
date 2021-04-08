package com.eci.ieti.services.impl;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.services.TravelService;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Store;
import com.eci.ieti.model.Travel;
import com.eci.ieti.persistence.TravelPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {


    @Autowired
    private TravelPersistenceService travelRepository;

    @Override
    public List<Travel> getUserTravels(String user) throws TravelException {
        try {
            return travelRepository.getUserTravels(user);
        } catch (TravelPersistenceException e) {
            throw new TravelException(e.getMessage(), e);
        }
    }

    @Override
    public List<Store> getStores(String category) throws TravelException {
        // TODO Auto-generated method stub
        return null;
    }
}
