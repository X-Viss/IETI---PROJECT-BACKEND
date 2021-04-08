package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository{

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserModel user) {
        userRepository.insert(user);        
    }    
    
    @Override
    public UserModel getName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public void updateUser(String name, String email, String password, Integer phone) {
        UserModel user = userRepository.findByUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);


        
    }

    

}
