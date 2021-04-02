package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Place, String> {
}
