package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

}
