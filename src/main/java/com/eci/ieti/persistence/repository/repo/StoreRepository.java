package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StoreRepository extends MongoRepository<Store, String> {

}