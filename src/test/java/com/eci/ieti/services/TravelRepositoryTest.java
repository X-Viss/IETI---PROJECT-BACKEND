package com.eci.ieti.services;

import com.eci.ieti.TravelService;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Travel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TravelRepositoryTest {

    @Autowired
    private TravelService travelService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void getTravelsTest(){
        try {
            List<Travel> travels = travelService.getUserTravels("");
            assertEquals(travels, null);
        } catch (TravelException e) {
            e.printStackTrace();
        }
    }

}
