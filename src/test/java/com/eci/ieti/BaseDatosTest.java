package com.eci.ieti;

import static org.junit.Assert.assertEquals;

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

    @Autowired
    CustomRepository customRepository;
    
    @Before
    public void setUp(){
        User user = new User("Prueba", "123");
        customRepository.createUser(user);
    }

    @Test
    public void createData() {
        User var = customRepository.getName("Prueba");
        assertEquals("123", var.getpassword());
    }
}
