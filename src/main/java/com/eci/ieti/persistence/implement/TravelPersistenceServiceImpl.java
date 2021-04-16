package com.eci.ieti.persistence.implement;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.UserModel;
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

    /**
     * Get the persisted travels from the user
     * @param user Name of the user
     * @return List of user travels
     * @throws TravelPersistenceException If the user does not exist
     */
    @Override
    public List<Travel> getUserTravels(String user) throws TravelPersistenceException {
        UserModel actualUser = userRepository.findByUserName(user);
        if(actualUser==null){
            throw new TravelPersistenceException(TravelPersistenceException.USER_NOT_FOUND);
        }
        return travelRepository.findByUser(user);
    }

    @Override
    public void updateTravelCategory(List<GeneritToUserRolWeatherOrCategory> newCategory, String travelId) {
        Travel travel = travelRepository.findUserRolSelectById(travelId);
        travel.setSeveralList(newCategory);
        travelRepository.save(travel);
    }
}
