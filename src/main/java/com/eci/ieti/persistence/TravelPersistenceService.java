package com.eci.ieti.persistence;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelPersistenceService {

    public List<Travel> getUserTravels(String user) throws TravelPersistenceException;

}
