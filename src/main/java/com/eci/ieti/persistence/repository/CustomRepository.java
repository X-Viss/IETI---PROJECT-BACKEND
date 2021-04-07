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

    public void putWeahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id);

    public void putAccessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id);

    public void putOnHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id);

    public void putCleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id);

    public void putShoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id);

    public void putMedicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id);

    public void putClothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id);

    public void putSeveralByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id);
}
