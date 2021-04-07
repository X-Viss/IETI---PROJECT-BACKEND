package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolRepository userRolRepository;

    @Override
    public void createUser(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        String id = java.util.UUID.randomUUID().toString();
        UserRolSelect user = new UserRolSelect(id, generitToUserRolWeatherOrCategoryList);
        userRolRepository.insert(user);
        return id;
    }

    @Override
    public void putDestinyByUserRolSelected(Country destiny, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setDestiny(destiny.getCountry());
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void weahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(weatherList);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void accessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(accessories);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void onHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(onhand);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void cleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(cleanliness);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void shoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(shopping);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void medicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(medicine);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void clothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(clothes);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void severalByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(several);
        userRolRepository.save(userRolSelect);
    }


}
