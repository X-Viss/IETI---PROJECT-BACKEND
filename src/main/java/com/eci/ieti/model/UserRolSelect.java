package com.eci.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "UserRol")
public class UserRolSelect {

    @Id
    public String id;
    public List<UserRol> userRolList;
    public List<Weather> weatherList;
    public String destiny;

    public UserRolSelect() {
    }

    public UserRolSelect(String id, List<UserRol> userRolList) {
        this.id = id;
        this.userRolList = userRolList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public List<UserRol> getUserRolList() {
        return userRolList;
    }

    public void setUserRolList(List<UserRol> userRolList) {
        this.userRolList = userRolList;
    }
}
