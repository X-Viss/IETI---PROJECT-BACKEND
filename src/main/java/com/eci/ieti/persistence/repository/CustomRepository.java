package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.UserModel;

public interface CustomRepository{
    public void createUser(UserModel user);
    public UserModel getName(String name);
    public void updateUser(String name,String email, String password, Integer phone);
}
