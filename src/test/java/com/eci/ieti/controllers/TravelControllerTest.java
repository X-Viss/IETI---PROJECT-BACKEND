package com.eci.ieti.controllers;


import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @Autowired
    private UserRolRepository userRolRepository;

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
    public void postUserRoleShouldBeCreated() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();

        mockMvc.perform( post("/api/create/rol")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(generitToUserRolWeatherOrCategoryList)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldBePutUserRolSelectDestiny() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("1", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        Country country = new Country();

        mockMvc.perform( put("/api/create/destiny?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(country)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectAccessories() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("3", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/accessories?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectOnHand() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("4", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/onhand?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectCleanliness() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("5", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/cleanliness?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectShopping() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("6", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/shopping?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectMedicine() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("7", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/medicine?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectClothes() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("8", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/clothes?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void severalBePutUserRolSelectSeveral() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("9", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/several?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
