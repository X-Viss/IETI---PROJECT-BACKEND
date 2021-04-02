package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TravelRepository extends MongoRepository<Travel, String> {

    public List<Travel> findByUser(String email);

}
