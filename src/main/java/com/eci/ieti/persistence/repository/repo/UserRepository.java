package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String>{

    UserModel findByUserName(String name);
    
}
