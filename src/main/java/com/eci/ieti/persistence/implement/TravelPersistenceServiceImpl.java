package com.eci.ieti.persistence.implement;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.User;
import com.eci.ieti.persistence.TravelPersistenceService;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPersistenceServiceImpl implements TravelPersistenceService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Travel> getUserTravels(String user) throws TravelPersistenceException {
        User actualUser = userRepository.findByUserName(user);
        if(actualUser==null){
            throw new TravelPersistenceException(TravelPersistenceException.USER_NOT_FOUND);
        }
        System.out.println(actualUser);
        return travelRepository.findByUser(user);
    }
}