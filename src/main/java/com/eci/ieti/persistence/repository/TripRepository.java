package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends MongoRepository<Trip, Integer> {

    List<Trip> findByNametrip(String nametrip);

}
