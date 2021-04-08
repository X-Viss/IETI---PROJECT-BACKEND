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
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Security {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void Autenticated()throws Exception{
        MvcResult mvcResult = mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Succesful subscription for client Luisa\"}",mvcResult.getResponse().getContentAsString());
    }

    public void authenticateClient() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        MvcResult mvcResult2 = mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Succesful Authentication for client Luisa\"}",mvcResult2.getResponse().getContentAsString());
    }

}
