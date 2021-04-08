package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{

    UserModel findByUserName(String name);
    
}
