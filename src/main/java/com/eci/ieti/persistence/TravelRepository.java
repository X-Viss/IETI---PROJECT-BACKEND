package com.eci.ieti.persistence;

import com.eci.ieti.model.Travel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository {

    public List<Travel> getUserTravels(String user);

}
