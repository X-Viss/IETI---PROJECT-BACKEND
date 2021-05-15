package com.eci.ieti.persistence.implement;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Store;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.Travel;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.TravelPersistenceService;
import com.eci.ieti.persistence.repository.repo.StoreRepository;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelPersistenceServiceImpl implements TravelPersistenceService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;

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
    public void deleteTravel(String id) throws TravelPersistenceException {
        Travel travel = travelRepository.deleteByTravelId(id);
        if(travel == null){
            throw new TravelPersistenceException(TravelPersistenceException.TRAVEL_NOT_FOUND);
        }
        System.out.println(travel.getTravelId());
    }

    @Override
    public List<Store> getStores(String category){
        
        List<Store> storeTemp = storeRepository.findAll();

        List<Store> filteredStores = new ArrayList<>();

        for (Store store : storeTemp) {
            List<String> tagCat = store.getTagCategories();
            if(tagCat.contains(category)){
                filteredStores.add(store);
            }
        }

        return filteredStores;
    }
    public Travel getTravel(String travelId){
        return travelRepository.findUserRolSelectById(travelId);
    }

    @Override
    public void updateTravelCategory(List<GeneritToUserRolWeatherOrCategory> newCategory, String travelId) {
        Travel travel = travelRepository.findUserRolSelectById(travelId);
        travel.setSeveralList(newCategory);
        travelRepository.save(travel);
    }

    @Override
    public Travel getTravelById(String id) {
        return travelRepository.getByTravelId(id);
    }
}
