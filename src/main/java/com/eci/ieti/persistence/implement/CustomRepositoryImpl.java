package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.User;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolRepository userRolRepository;

    @Override
    public void createUser(User user) {
        userRepository.insert(user);        
    }    
    
    @Override
    public User getName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public void postTravelerRol(List<UserRol> userRolList) {
        userRolRepository.insert(userRolList);
    }

}
