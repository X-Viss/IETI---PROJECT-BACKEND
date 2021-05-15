package com.eci.ieti.services.impl;

import com.eci.ieti.exceptions.persistence.TravelPersistenceException;
import com.eci.ieti.model.Country;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.model.ListCategories;
import com.eci.ieti.model.Travel;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.services.TravelService;
import com.eci.ieti.exceptions.TravelException;
import com.eci.ieti.model.Store;
import com.eci.ieti.persistence.TravelPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {


    @Autowired
    private TravelPersistenceService travelRepository;

    @Autowired
    private CustomRepository customRepositoryImpl;

    @Override
    public List<Travel> getUserTravels(String user) throws TravelException {
        try {
            return travelRepository.getUserTravels(user);
        } catch (TravelPersistenceException e) {
            throw new TravelException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteTravel(String id) throws TravelException {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Travel travel = travelRepository.getTravelById(id);
        if(travel == null){
            throw new TravelException(TravelException.TRAVEL_NOT_FOUND);
        }
        System.out.println("SESSION" + user);
        System.out.println("MONGO" + travel.getUser());
        if(!user.equals(travel.getUser())){
            throw new TravelException(TravelException.NOT_AUTHORIZED);
        }
        try {
            travelRepository.deleteTravel(id);
        } catch (TravelPersistenceException e) {
            throw new TravelException(TravelException.TRAVEL_NOT_FOUND, e);
        }
    }

    @Override
    public List<Store> getStores(String category){
        return travelRepository.getStores(category);
    }
    public Travel getTravel(String travelId){
        return travelRepository.getTravel(travelId);
    }
    
    public void updateTravelCategory(List<GeneritToUserRolWeatherOrCategory> newCategory, String travelId) {
        travelRepository.updateTravelCategory(newCategory, travelId);
        
    }
    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList, String id) {
        return customRepositoryImpl.postTravelerRol(generitToUserRolWeatherOrCategoryList, id);
    }

    @Override
    public void putDestinyByUserRolSelected(Country destiny, String id) {
        customRepositoryImpl.putDestinyByUserRolSelected(destiny, id);
    }

    @Override
    public ListCategories putWeahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id) {
        return customRepositoryImpl.weahterByUserRolSelected(weatherList, id);
    }

    @Override
    public void putAccessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id) {
        customRepositoryImpl.accessoriesByUserRolSelected(accessories, id);
    }

    @Override
    public void putOnHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id) {
        customRepositoryImpl.onHandByUserRolSelected(onhand, id);
    }

    @Override
    public void putCleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id) {
        customRepositoryImpl.cleanlinessByUserRolSelected(cleanliness, id);
    }

    @Override
    public void putShoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id) {
        customRepositoryImpl.shoppingByUserRolSelected(shopping, id);
    }

    @Override
    public void putMedicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id) {
        customRepositoryImpl.medicineByUserRolSelected(medicine, id);
    }

    @Override
    public void putClothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id) {
        customRepositoryImpl.clothesByUserRolSelected(clothes, id);
    }

    @Override
    public void putSeveralByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id) {
        customRepositoryImpl.severalByUserRolSelected(several, id);
    }

    @Override
    public void putTitleAndHour(String title, Date date, String id) {
        customRepositoryImpl.putTitleAndHour(title, date, id);
    }

}
