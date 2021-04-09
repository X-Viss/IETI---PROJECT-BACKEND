package com.eci.ieti;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.eci.ieti.persistence.repository.repo.UserRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void Autenticated()throws Exception{
        MvcResult mvcResult = mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Succesful subscription for client Luisa\"}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void authenticateClient() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        MvcResult mvcResult2 = mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Succesful Authentication for client Luisa\"}",mvcResult2.getResponse().getContentAsString());
    }

    @Test
    public void NotAutenticated()throws Exception{
        
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisaa\",\"password\" : \"pssw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisaa\",\"password\" : \"pssw\"}"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();
    }

    @Test
    public void notAuthenticateClient() throws Exception{
        MvcResult mvcResult2 = mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"Maria\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Error during Authentication Maria\"}",mvcResult2.getResponse().getContentAsString());
    }
}
