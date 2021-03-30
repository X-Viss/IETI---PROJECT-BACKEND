package com.eci.ieti;

import static org.junit.Assert.assertEquals;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BagTravBackendApp.class)
public class BaseDatosTest {

    @Autowired
    CustomRepository customRepository;
    
    @Test
    public void createData() {
        User user = new User("Prueba", "123");
        customRepository.createUser(user);
        User var = customRepository.getName("Prueba");
        assertEquals("123", var.getpassword());
    }

    @Test 
    public void getData(){
        User var = customRepository.getName("Luisa");
        assertEquals("321", var.getpassword());
    } 

    @Test
    public void createUser(){
        User user = new User();
        user.setUserName("Prueba2");
        user.setpassword("4567");
        assertEquals("4567", user.getpassword());
        assertEquals("Prueba2", user.getUserName());
    }

}
