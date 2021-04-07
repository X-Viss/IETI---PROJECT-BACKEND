package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.Country;
import com.eci.ieti.model.User;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;

import java.util.List;

public interface CustomRepository{

    public void createUser(User user);
    public User getName(String name);

    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList);

    public void putDestinyByUserRolSelected(Country destiny, String id);

    void putWeahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id);
}
