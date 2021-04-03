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

}
