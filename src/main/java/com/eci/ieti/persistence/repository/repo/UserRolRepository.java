package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.UserRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRolRepository extends MongoRepository<UserRol, String> {

}
