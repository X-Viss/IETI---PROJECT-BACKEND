package com.eci.ieti.services;

import java.util.ArrayList;

import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel foundedUser = userRepository.findByUserName(username);
        if (foundedUser == null){
            return null;
        }

        String name = foundedUser.getUserName();
        String pws = foundedUser.getPassword();

        return new User(name, pws, new ArrayList<>());
    }
    
}
