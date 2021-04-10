package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.WeatherCategoryRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherCategoryRolRepository extends MongoRepository<WeatherCategoryRol, String> {

    WeatherCategoryRol findCategoryById(String id);
}
