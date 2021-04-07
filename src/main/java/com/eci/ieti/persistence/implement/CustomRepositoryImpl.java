package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.Country;
import com.eci.ieti.model.User;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.model.UserRolSelect;
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
    public String postTravelerRol(List<UserRol> userRolList) {
        String id = java.util.UUID.randomUUID().toString();
        UserRolSelect user = new UserRolSelect(id, userRolList);
        userRolRepository.insert(user);
        return id;
    }

    @Override
    public void putDestinyByUserRolSelected(Country destiny, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        System.out.println("");
        System.out.println("");
        System.out.println(destiny.getCountry());
        System.out.println(id+ "    id llegada");
        System.out.println(userRolSelect.getId());
        userRolSelect.setDestiny(destiny.getCountry());
        userRolRepository.save(userRolSelect);
    }


}
