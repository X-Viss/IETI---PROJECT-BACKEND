package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TravelRepository extends MongoRepository<Travel, String> {

    /**
     * Find the user travels by name of the user owner
     * @param user User name
     * @return List of the user travels
     */
    public List<Travel> findByUser(String user);


    /**
     * Delete the travel with the specified id
     * @param travelId Travel id
     * @return The deleted travel
     */
    public List<Travel> deleteByTravelId(String travelId);


    /**
     * Saves the travel in the database
     * @param travel Travel to save
     * @return Travel saved in the database
     */
    public Travel save(Travel travel);
}
