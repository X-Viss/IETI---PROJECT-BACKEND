package com.eci.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "UserRol")
public class UserRolSelect {

    @Id
    public String id;
    public List<GeneritToUserRolWeatherOrCategory> userRolList;
    public List<GeneritToUserRolWeatherOrCategory> weatherList;
    public String destiny;

    public UserRolSelect() {
    }

    public UserRolSelect(String id, List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        this.id = id;
        this.userRolList = generitToUserRolWeatherOrCategoryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<GeneritToUserRolWeatherOrCategory> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<GeneritToUserRolWeatherOrCategory> weatherList) {
        this.weatherList = weatherList;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public List<GeneritToUserRolWeatherOrCategory> getUserRolList() {
        return userRolList;
    }

    public void setUserRolList(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        this.userRolList = generitToUserRolWeatherOrCategoryList;
    }
}
