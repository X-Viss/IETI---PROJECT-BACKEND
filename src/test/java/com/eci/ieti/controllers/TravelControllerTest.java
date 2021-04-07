package com.eci.ieti.controllers;


import com.eci.ieti.model.User;
import com.eci.ieti.model.UserRol;
import com.eci.ieti.model.UserRolSelect;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getTravelsShouldExist() throws Exception {
        User user = new User();
        user.setUserName("david");
        user.setpassword("123456joke");
        userRepository.save(user);
        mockMvc.perform(get("/api/travels?user=david")).andDo(print()).andExpect(status().isOk());


        User user2 = new User();
        user2.setUserName("jose");
        user2.setpassword("123456joke");
        userRepository.save(user2);
        mockMvc.perform(get("/api/travels?user=jose")).andDo(print()).andExpect(status().isOk());

        User user3 = new User();
        user3.setUserName("pepito");
        user3.setpassword("123456joke");
        userRepository.save(user3);
        mockMvc.perform(get("/api/travels?user=pepito")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void getTravelsShouldNotExist() throws Exception {
        mockMvc.perform(get("/api/travels?user=123")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=456")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=omg")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=dfdfdf")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=45dfsdfds6")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=4sfdsfsdf56")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=sdfsdfdsfsd456")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getTravelShouldBeEmpty() throws Exception {
        User user = new User();
        user.setUserName("davinchi");
        user.setpassword("123456joke");
        userRepository.save(user);
        ResultActions result = mockMvc.perform(get("/api/travels?user=davinchi")).andDo(print()).andExpect(status().isOk()).andExpect(
                content().json("[]")
        );
    }

    @Test
    public void getUserRole() throws Exception {

        List<UserRol> userRolList = new ArrayList<>();

        mockMvc.perform( post("/api/create/rol")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userRolList)))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
