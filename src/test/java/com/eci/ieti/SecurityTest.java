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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.eci.ieti.configuration.JwtUtils;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtils jwtlUtils;
    
    @Test
    public void Autenticated()throws Exception{
        MvcResult mvcResult = mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisa@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"Succesful subscription for client Luisa@mail.com\"}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void authenticateClient() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Felipe@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"Felipe@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
    }

    @Test
    public void NotAutenticated()throws Exception{
        
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisaa@mail.com\",\"password\" : \"pssw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        /**
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisaa@mail.com\",\"password\" : \"pssw\"}"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();
         */
    }

    @Test
    public void notAuthenticateClient() throws Exception{
        mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"Maria\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isForbidden())
        .andReturn();
        
    }

    @Test
    public void authenticateClientToken() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"yesid@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        
        mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"yesid@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        MvcResult mvcResult = mockMvc
        .perform(get("/dashboard").header("Authorization", "Bearer "+jwtlUtils.getTokenString()))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        Assertions.assertEquals("{\"response\":\"yesid@mail.com\"}", mvcResult.getResponse().getContentAsString());
        
    }

    @Test
    public void notAuthenticateClientToken() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"alex@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
        
        mockMvc.perform(post("/auth").contentType("application/json")
        .content("{\"userName\" : \"alex@mail.com\",\"password\" : \"psw\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        mockMvc
        .perform(get("/dashboard").header("Authorization", "Bearerr "+jwtlUtils.getTokenString()))
        .andDo(print())
        .andExpect(status().isForbidden())
        .andReturn();

    }

    @Test
    public void Emailprobe() throws Exception{
        mockMvc.perform(post("/subs").contentType("application/json")
        .content("{\"userName\" : \"Luisaa\",\"password\" : \"pssw\"}"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();        
    }
}
