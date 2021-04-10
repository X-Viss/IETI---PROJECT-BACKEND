package com.eci.ieti;

import java.util.Date;

import com.eci.ieti.model.UserModel;
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
        Date date = new Date();
        UserModel user = new UserModel("prueba@mail.com","Prueba", "123", 314250,date,"Colombia");
        customRepository.createUser(user);
        UserModel var = customRepository.getName("Prueba");
        Assertions.assertEquals("123", var.getPassword());
    }

    @Test
    public void userRepo(){
        Date date = new Date();
        UserModel userG = new UserModel("luisa@mail.com","Luisa","321", 314250,date,"Colombia");
        customRepository.createUser(userG);
        UserModel var = userRepository.findByUserName("Luisa");
        Assertions.assertEquals("321", var.getPassword());
    }

    @Test
    public void insertUser(){
        UserModel userG = new UserModel();
        userG.setUserName("Luisa2");
        userG.setPassword("321");
        customRepository.createUser(userG);
        UserModel var = userRepository.findByUserName("Luisa2");
        Assertions.assertEquals("321", var.getPassword());
    }

    @Test
    public void updateUser(){
        Date date = new Date();
        UserModel userG = new UserModel("andres@mail.com","andres","321", 314250,date,"Colombia");
        customRepository.createUser(userG);
        customRepository.updateUser("andres", "andres@mail.com", "341", 310753);
        UserModel var = customRepository.getName("andres@mail.com");
        Assertions.assertEquals("341", var.getPassword());
    }
    

}
