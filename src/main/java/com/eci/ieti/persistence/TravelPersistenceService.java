package com.eci.ieti.persistence;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Store;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelPersistenceService {

    /**
     * Get the persisted travels from the user
     * @param user Name of the user
     * @return List of user travels
     * @throws TravelPersistenceException If the user does not exist
     */
    public List<Travel> getUserTravels(String user) throws TravelPersistenceException;

    public void deleteTravel(String id) throws TravelPersistenceException;

    public List<Store> getStores(String category);
    public Travel getTravel(String travelId);
    public void updateTravelCategory(List<GeneritToUserRolWeatherOrCategory> newCategory, String travelId);

    public Travel getTravelById(String id);
}
