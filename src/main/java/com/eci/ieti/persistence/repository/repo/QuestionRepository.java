package com.eci.ieti.persistence.repository.repo;

import com.eci.ieti.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String>{

}
