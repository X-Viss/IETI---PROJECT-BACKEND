package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.*;

import java.util.Date;
import java.util.List;

public interface CustomRepository{
    public void createUser(UserModel user);
    public UserModel getName(String name);
    public void updateUser(String name,String email, String password, Integer phone);

    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList, String id);

    public void putDestinyByUserRolSelected(Country destiny, String id);

    public ListCategories weahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id);

    public void accessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id);

    public void onHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id);

    public void cleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id);

    public void shoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id);

    public void medicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id);

    public void clothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id);

    public void severalByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id);

    void putTitleAndHour(String title, Date date, String id);
}
