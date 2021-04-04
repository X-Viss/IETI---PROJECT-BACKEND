package com.eci.ieti.controllers;


import com.eci.ieti.model.Travel;
import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

    private AtomicBoolean poblateLitle = new AtomicBoolean(false);
    private List<Travel> travelList = new ArrayList<Travel>();
    private ObjectMapper mapper = new ObjectMapper();

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
    public void addTravelShouldAddOk() throws Exception {
        User user = new User();
        user.setUserName("alejo");
        user.setpassword("123456joke");
        userRepository.save(user);

        String title1 = "Vacaciones";
        String description1 = "Mis vacaciones";
        String lugar1 = "Colombia";
        Date date = new Date();
        String username = user.getUserName();
        String travelId = "1";

        Travel travel = new Travel();
        travel.setTitle(title1);
        travel.setDescription(description1);
        travel.setLugar(lugar1);
        travel.setDueDate(date);
        travel.setUser(username);
        travel.setTravelId(travelId);
        travelRepository.save(travel);


        Travel travel2 = new Travel();
        travel2.setTitle(title1);
        travel2.setDescription(description1);
        travel2.setLugar(lugar1);
        travel2.setDueDate(date);
        travel2.setUser(username);
        travel2.setTravelId("2");
        travelRepository.save(travel2);

        Travel travel3 = new Travel();
        travel3.setTitle(title1);
        travel3.setDescription(description1);
        travel3.setLugar(lugar1);
        travel3.setDueDate(date);
        travel3.setUser(username);
        travel3.setTravelId("3");
        travelRepository.save(travel3);

        travelList.add(travel);
        travelList.add(travel2);
        travelList.add(travel3);

        System.out.println(travel);

        MvcResult result = mockMvc.perform(get("/api/travels?user="+user.getUserName())).andDo(print()).andExpect(status().isOk()).andReturn();

        List<Travel> myObjects = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Travel>>(){});
        Assert.assertEquals(myObjects, travelList);

    }

    @Test
    public void deleteTravelShouldFailNotExist() throws Exception {
        User user = new User();
        user.setUserName("sebastian");
        user.setpassword("123456joke");
        userRepository.save(user);

        String title1 = "Vacaciones camboya";
        String description1 = "Mis vacaciones again";
        String lugar1 = "Camboya";
        Date date = new Date();
        String username = user.getUserName();
        String travelId = "666";

        Travel travel = new Travel();
        travel.setTitle(title1);
        travel.setDescription(description1);
        travel.setLugar(lugar1);
        travel.setDueDate(date);
        travel.setUser(username);
        travel.setTravelId(travelId);
        travelRepository.save(travel);

        MvcResult result = mockMvc.perform(delete("/api/travels?travelId="+travel.getTravelId())).andDo(print()).andExpect(status().isOk()).andReturn();
        Travel deleted = mapper.readValue(result.getResponse().getContentAsString(), Travel.class);
        Assert.assertEquals(deleted, travel);


        mockMvc.perform(delete("/api/travels?travelId="+travel.getTravelId())).andDo(print()).andExpect(status().isBadRequest()).andReturn();
        System.out.println(deleted);
    }
}
