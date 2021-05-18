package com.eci.ieti.controllers;

import com.eci.ieti.configuration.JwtUtils;
import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.TravelPersistenceService;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravelRepository travelRepository;

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
    void getFaq() throws Exception {
        mockMvc.perform(get("/bag/faq")).andDo(print()).andExpect(status().isOk());
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
    void getTravelById() throws Exception {
        mockMvc.perform(get("/bag/travel?travelId=6078fda0fed2e61d4c48d58e")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getTravelByNoExistsId() throws Exception {
        mockMvc.perform(get("/bag/travel?travelId=")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void agregarElementosNuevaCategoria() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        Travel userTravel = new Travel("100123", generitToUserRolWeatherOrCategoryList);
        String id = userTravel.getId();
        travelRepository.insert(userTravel);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/bag/category/newCategory?travelId="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
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

    @Test
    void getStoresByCategoryNull() throws Exception {
        mockMvc.perform(get("/bag/stores")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    void getStoresByCategoryVacio() throws Exception {
        mockMvc.perform(get("/bag/stores?category=")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStoresByCategoryNoExiste() throws Exception {
        mockMvc.perform(get("/bag/stores?category=NULL")).andDo(print()).andExpect(status().isOk());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
