package com.eci.ieti.services;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Country;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    public List<Travel> getUserTravels(String user) throws TravelException;

    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList);

    public void putDestinyByUserRolSelected(Country destiny, String id);

    public void putWeahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id);
}
