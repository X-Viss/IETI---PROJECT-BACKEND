package com.eci.ieti.services;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    /**
     * Return the user travels
     * @param user Username of the actual user
     * @return A travel List of the specified user
     * @throws TravelException If the user does not exist
     */
    public List<Travel> getUserTravels(String user) throws TravelException;

    /**
     * Deletes the travel by a given id
     * @param travelId Travel Id
     * @return The deleted travel
     * @throws TravelException If the travel does not exist
     */
    public Travel deleteTravelById(String travelId) throws TravelException;
}
