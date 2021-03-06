package com.eci.ieti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LocationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
   void getLocations() throws Exception {
        mockMvc.perform(get("/Locations")).andDo(print()).andExpect(status().isOk());
  }

    @Test
    void getLocation() throws Exception {
        mockMvc.perform(get("/Locations/Ourense")).andDo(print()).andExpect(status().isOk());
    }
}
