package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.User;
import com.eci.ieti.model.UserRol;

import java.util.List;

public interface CustomRepository{

    public void createUser(User user);
    public User getName(String name);

    public String postTravelerRol(List<UserRol> userRolList);
}
