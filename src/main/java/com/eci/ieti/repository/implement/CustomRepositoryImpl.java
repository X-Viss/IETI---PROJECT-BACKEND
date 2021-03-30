package com.eci.ieti.repository.implement;

import com.eci.ieti.model.User;
import com.eci.ieti.repository.CustomRepository;
import com.eci.ieti.repository.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository{

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.insert(user);        
    }    
    
}
