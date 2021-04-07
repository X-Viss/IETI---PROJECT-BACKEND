package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.UserRolSelect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRolRepository extends MongoRepository<UserRolSelect, String> {

}
