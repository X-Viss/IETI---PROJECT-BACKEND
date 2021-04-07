package com.eci.ieti.services.impl;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Country;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.model.Weather;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.services.TravelService;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Travel;
import com.eci.ieti.persistence.TravelPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {


    @Autowired
    private TravelPersistenceService travelRepository;

    @Autowired
    private CustomRepository customRepositoryImpl;

    @Override
    public List<Travel> getUserTravels(String user) throws TravelException {
        try {
            return travelRepository.getUserTravels(user);
        } catch (TravelPersistenceException e) {
            throw new TravelException(e.getMessage(), e);
        }
    }

    @Override
    public String postTravelerRol(List<UserRol> userRolList) {
        return customRepositoryImpl.postTravelerRol(userRolList);
    }

    @Override
    public void putDestinyByUserRolSelected(Country destiny, String id) {
        customRepositoryImpl.putDestinyByUserRolSelected(destiny, id);
    }

    @Override
    public void putWeahterByUserRolSelected(List<Weather> weatherList, String id) {
        customRepositoryImpl.putWeahterByUserRolSelected(weatherList, id);
    }

}
