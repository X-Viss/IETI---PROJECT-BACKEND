package com.eci.ieti.persistence.repository;

import com.eci.ieti.model.User;

public interface CustomRepository{
    public void createUser(User user);
    public User getName(String name);
}
