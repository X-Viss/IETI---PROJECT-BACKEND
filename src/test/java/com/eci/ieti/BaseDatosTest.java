package com.eci.ieti;

import static org.junit.Assert.assertEquals;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

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
    UserRepository userRepository;

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
    public void userRepo(){
        User var = userRepository.findByUserName("Luisa");
        assertEquals("321", var.getpassword());
    }

}
