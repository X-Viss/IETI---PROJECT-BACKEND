package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    public User findByUserName(String name);
    
}
