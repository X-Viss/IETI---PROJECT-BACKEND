package com.eci.ieti.services;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Country;
import com.eci.ieti.model.ListCategories;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    public List<Travel> getUserTravels(String user) throws TravelException;

    public Travel getTravel(String travelId);

    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList);

    public void putDestinyByUserRolSelected(Country destiny, String id);

    public ListCategories putWeahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id);

    public void putAccessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id);

    public void putOnHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id);

    public void putCleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id);

    public void putShoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id);

    public void putMedicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id);

    public void putClothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id);

    public void putSeveralByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id);
}
