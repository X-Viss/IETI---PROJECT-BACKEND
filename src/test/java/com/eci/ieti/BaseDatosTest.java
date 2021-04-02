package com.eci.ieti;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDatosTest {

    @Autowired
    CustomRepository customRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void insertData() {
        User user = new User("Prueba", "123");
        customRepository.createUser(user);
        User var = customRepository.getName("Prueba");
        Assertions.assertEquals("123", var.getpassword());
    }

    @Test
    public void userRepo(){
        User userG = new User("Luisa","321");
        customRepository.createUser(userG);
        User var = userRepository.findByUserName("Luisa");
        Assertions.assertEquals("321", var.getpassword());
    }

    @Test
    public void insertUser(){
        User userG = new User();
        userG.setUserName("Luisa2");
        userG.setpassword("321");
        customRepository.createUser(userG);
        User var = userRepository.findByUserName("Luisa2");
        Assertions.assertEquals("321", var.getpassword());
    }

}
