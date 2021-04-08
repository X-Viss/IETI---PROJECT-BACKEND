package com.eci.ieti;

import org.junit.Test;
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




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Security {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void Autenticated()throws Exception{
        System.out.println("-----------------------------------------------------");
        MvcResult mvcResult = mockMvc.perform(post("/subs")).andDo(print())
        .andExpect(status().isOk()).andExpect(content()
        .contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.userName").value("Luisa"))
        .andExpect(jsonPath("$.password").value("psw"))
        .andReturn();
        System.out.println("-----------------------------------------------------");
        System.out.println(mvcResult.toString());
    
    }
}
