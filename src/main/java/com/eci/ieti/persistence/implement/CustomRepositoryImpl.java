package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolRepository userRolRepository;

    @Autowired
    WeatherCategoryRolRepository weatherCategoryRolRepository;

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
    public ListCategories weahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id) {
        ListCategories listCategories = new ListCategories();
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setWeatherList(weatherList);
        String weatherName = getWeatherNaer(weatherList);
        List<String> rolName = getRolsName(userRolSelect);
        ListCategories toReturn = combinations(listCategories, weatherName, rolName);
        userRolRepository.save(userRolSelect);
        return toReturn;
    }

    @Override
    public void accessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setAccessoriesList(accessories);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void onHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setOnHandList(onhand);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void cleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setCleanlinessList(cleanliness);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void shoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setShoppingList(shopping);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void medicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setMedicineList(medicine);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void clothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setClothesList(clothes);
        userRolRepository.save(userRolSelect);
    }

    @Override
    public void severalByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id) {
        UserRolSelect userRolSelect = userRolRepository.findUserRolSelectById(id);
        userRolSelect.setSeveralList(several);
        userRolRepository.save(userRolSelect);
    }

    private String getWeatherNaer(List<GeneritToUserRolWeatherOrCategory> weatherList) {
        String name = null;
        for (GeneritToUserRolWeatherOrCategory data : weatherList) {
            if (data.isCheck()) {
                name = data.getName();
            }
        }
        return name;
    }

    private List<String> getRolsName(UserRolSelect userRolSelect) {
        List<String> list = new ArrayList<>();
        for (GeneritToUserRolWeatherOrCategory data : userRolSelect.getUserRolList()) {
            if (data.isCheck()) {
                list.add(data.getName());
            }
        }
        return list;
    }

    private ListCategories combinations(ListCategories listCategories, String weatherName, List<String> rolName) {

        WeatherCategoryRol wetherList = weatherCategoryRolRepository.findCategoryById(weatherName);
        WeatherCategoryRol health = weatherCategoryRolRepository.findCategoryById("Salud");
        WeatherCategoryRol cleanness = weatherCategoryRolRepository.findCategoryById("Aseo");
        WeatherCategoryRol onHand = weatherCategoryRolRepository.findCategoryById("Mano");
        WeatherCategoryRol pets = null;
        WeatherCategoryRol work = null;
        WeatherCategoryRol couple = null;
        WeatherCategoryRol backpacker = null;
        WeatherCategoryRol tourist = null;

        for (String data : rolName) {
            if (data.equals("Viaje con mascotas")) {
                pets = weatherCategoryRolRepository.findCategoryById("Mascota");
            } else if (data.equals("Viaje como Mochilero")) {
                backpacker = weatherCategoryRolRepository.findCategoryById("Mochilero");
            } else if (data.equals("Viaje en pareja")) {
                couple = weatherCategoryRolRepository.findCategoryById("Pareja");
            } else if (data.equals("Viaje como turista")) {
                tourist = weatherCategoryRolRepository.findCategoryById("Turista");
            } else {
                work = weatherCategoryRolRepository.findCategoryById("Trabajo");
            }
        }

        List<String> accesoriesList = compareAccesories(weatherName, wetherList, health, cleanness, onHand, pets, work, couple, backpacker, tourist);
        List<String> clothesList = compareClothes(weatherName, wetherList, health, cleanness, onHand, pets, work, couple, backpacker, tourist);
        List<String> cleannessList = compareCleanness(weatherName, wetherList, health, cleanness, onHand, pets, work, couple, backpacker, tourist);
        List<String> healthList = compareHealth(weatherName, wetherList, health, cleanness, onHand, pets, work, couple, backpacker, tourist);
        List<String> onHandList = compareOnHand(weatherName, wetherList, health, cleanness, onHand, pets, work, couple, backpacker, tourist);
        listCategories.setAccesoriesList(accesoriesList);
        listCategories.setClothesList(clothesList);
        listCategories.setOnHandList(onHandList);
        listCategories.setCleannessList(cleannessList);
        listCategories.setHealthList(healthList);

        return listCategories;
    }

    private List<String> compareOnHand(String weatherName, WeatherCategoryRol wetherList,
                                       WeatherCategoryRol health, WeatherCategoryRol cleanness,
                                       WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                       WeatherCategoryRol work, WeatherCategoryRol couple,
                                       WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {
        List<String> res = new ArrayList<>();

        for (String data : onHand.getOnHand()) {
            res.add(data);

        }

        if(pets!=null) {
            for (String data : pets.getPetsOnHand()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(work!=null) {
            for (String data : work.getWorkOnHand()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }
        return res;

    }

    private List<String> compareHealth(String weatherName, WeatherCategoryRol wetherList,
                                       WeatherCategoryRol health, WeatherCategoryRol cleanness,
                                       WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                       WeatherCategoryRol work, WeatherCategoryRol couple,
                                       WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {
        List<String> res = new ArrayList<>();

        for (String data : health.getHealth()) {
            res.add(data);
        }

        if(work!=null) {
            for (String data : work.getWorkHealth()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }

    private List<String> compareCleanness(String weatherName, WeatherCategoryRol wetherList,
                                          WeatherCategoryRol health, WeatherCategoryRol cleanness,
                                          WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                          WeatherCategoryRol work, WeatherCategoryRol couple,
                                          WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {

        List<String> res = new ArrayList<>();
        for (String data : cleanness.getCleanness()) {
            res.add(data);
        }
        return res;
    }

    private List<String> compareClothes(String weatherName, WeatherCategoryRol wetherList,
                                        WeatherCategoryRol health, WeatherCategoryRol cleanness,
                                        WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                        WeatherCategoryRol work, WeatherCategoryRol couple,
                                        WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {
        List<String> res = new ArrayList<>();
        if (weatherName.equals("Primavera")) {
            if(wetherList.getSpringAccesories()!=null) {
                for (String data : wetherList.getSpringClothes()) {
                    res.add(data);
                }
            }
        } else if (weatherName.equals("Verano")) {
            if(wetherList.getSummerAccesories()!=null) {
                for (String data : wetherList.getSummerClothes()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        } else if (weatherName.equals("Otoño")) {
            if(wetherList.getAutumnAccesories()!=null) {
                for (String data : wetherList.getAutumnClothes()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        } else {
            for (String data : wetherList.getWinterClothes()) {
                if (wetherList.getWinterAccesories() != null) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        }

        if(pets!=null) {
            for (String data : pets.getPetsClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(work!=null) {
            for (String data : work.getWorkClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(backpacker!=null) {
            for (String data : backpacker.getBackpackerClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(tourist!=null) {
            for (String data : tourist.getTouristClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }

    public List<String> compareAccesories(String weatherName, WeatherCategoryRol wetherList,
                                          WeatherCategoryRol health, WeatherCategoryRol cleanness,
                                          WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                          WeatherCategoryRol work, WeatherCategoryRol couple,
                                          WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {

        List<String> res = new ArrayList<>();
        if (weatherName.equals("Primavera")) {
            if(wetherList.getSpringAccesories()!=null) {
                for (String data : wetherList.getSpringAccesories()) {
                    res.add(data);
                }
            }
        } else if (weatherName.equals("Verano")) {
            if(wetherList.getSummerAccesories()!=null) {
                for (String data : wetherList.getSummerAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        } else if (weatherName.equals("Otoño")) {
            if(wetherList.getAutumnAccesories()!=null) {
                for (String data : wetherList.getAutumnAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        } else {
            if (wetherList.getWinterAccesories() != null) {
                for (String data : wetherList.getWinterAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        }

        if(pets!=null) {
            for (String data : pets.getPetsAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(work!=null) {
            for (String data : work.getWorkAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(couple!=null) {
            for (String data : couple.getCoupleAcceosires()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(backpacker!=null) {
            for (String data : backpacker.getBackpackerAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if(tourist!=null) {
            for (String data : tourist.getTouristAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }
}
