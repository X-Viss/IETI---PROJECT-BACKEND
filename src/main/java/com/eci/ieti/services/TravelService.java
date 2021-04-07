package com.eci.ieti.services;

import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.UserRol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    public List<Travel> getUserTravels(String user) throws TravelException;

    public String postTravelerRol(List<UserRol> userRolList) throws TravelException;
}
