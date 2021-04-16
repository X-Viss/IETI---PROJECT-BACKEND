package com.eci.ieti.controllers;


import com.eci.ieti.configuration.JwtUtils;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtlUtils;

    @Test
    public void getTravelsShouldExist() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("david");
        user.setPassword("123456joke");
        userRepository.save(user);
        mockMvc.perform(get("/api/travels?user=david").header("Authorization", "Bearer "+jwtlUtils.getTokenString()))
        .andDo(print()).andExpect(status().isOk());


        UserModel user2 = new UserModel();
        user2.setUserName("jose");
        user2.setPassword("123456joke");
        userRepository.save(user2);
        mockMvc.perform(get("/api/travels?user=jose").header("Authorization", "Bearer "+jwtlUtils.getTokenString()))
        .andDo(print()).andExpect(status().isOk());

        UserModel user3 = new UserModel();
        user3.setUserName("pepito");
        user3.setPassword("123456joke");
        userRepository.save(user3);
        mockMvc.perform(get("/api/travels?user=pepito").header("Authorization", "Bearer "+jwtlUtils.getTokenString()))
        .andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void getTravelsShouldNotExist() throws Exception {
        mockMvc.perform(get("/api/travels?user=123").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=456").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=omg").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=dfdfdf").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=45dfsdfds6").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=4sfdsfsdf56").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=sdfsdfdsfsd456").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getTravelShouldBeEmpty() throws Exception {
        UserModel user = new UserModel();
        user.setUserName("davinchi");
        user.setPassword("123456joke");
        userRepository.save(user);
        mockMvc.perform(get("/api/travels?user=davinchi").header("Authorization", "Bearer "+jwtlUtils.getTokenString())).andDo(print()).andExpect(status().isOk()).andExpect(
                content().json("[]")
        );
    }

    @Test
    void getStoresByCategoryAseo() throws Exception {
        mockMvc.perform(get("/bag/stores?category=ASEO")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStoresByCategoryALaMano() throws Exception {
        mockMvc.perform(get("/bag/stores?category=A LA MANO")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStoresByCategorySalud() throws Exception {
        mockMvc.perform(get("/bag/stores?category=SALUD")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStoresByCategoryAccesorios() throws Exception {
        mockMvc.perform(get("/bag/stores?category=ACCESORIOS")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStoresByCategoryRopa() throws Exception {
        mockMvc.perform(get("/bag/stores?category=ROPA")).andDo(print()).andExpect(status().isOk());
    }



}