package com.eci.ieti.persistence.impl;

import com.eci.ieti.model.Travel;
import com.eci.ieti.persistence.TravelRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelRepositoryImpl implements TravelRepository {
    @Override
    public List<Travel> getUserTravels(String user) {
        return null;
    }
}
