package com.eci.ieti;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BagTravBackendApp.class)
public class BaseDatosTest {
    private User userG;
    @Autowired
    CustomRepository customRepository;

    @Before
    public void setUp (){
        userG =  new User();
    }
    
    @Test
    public void createData() {
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
        userG.setUserName("Prueba2");
        userG.setpassword("4567");
        assertEquals("4567", userG.getpassword());
        assertEquals("Prueba2", userG.getUserName());
    }

}
