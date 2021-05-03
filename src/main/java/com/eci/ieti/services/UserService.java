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

        System.out.println(username);
        UserModel foundedUser = userRepository.findByUserName(username);
        System.out.println(foundedUser);
        if (foundedUser == null){
            return null;
        }

        String name = foundedUser.getUserName();
        String pws = foundedUser.getPassword();

        System.out.println(name);
        System.out.println("WTF" + pws);
        return new User(name, pws, new ArrayList<>());
    }
    
}
