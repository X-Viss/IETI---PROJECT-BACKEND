package com.eci.ieti.persistence.repository.implement;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

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
    
    @Override
    public User getName(String name) {
        return userRepository.findByUserName(name);
    }    
    
}
