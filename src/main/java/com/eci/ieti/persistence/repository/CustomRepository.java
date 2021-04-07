package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.Country;
import com.eci.ieti.model.User;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.model.Weather;

import java.util.List;

public interface CustomRepository{

    public void createUser(User user);
    public User getName(String name);

    public String postTravelerRol(List<UserRol> userRolList);

    public void putDestinyByUserRolSelected(Country destiny, String id);

    void putWeahterByUserRolSelected(List<Weather> weatherList, String id);
}
