package com.eci.ieti.persistence.implement;

import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("CustomRepository")
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TravelRepository travelRepository;

    @Autowired
    WeatherCategoryRolRepository weatherCategoryRolRepository;
    

    @Override
    public void createUser(UserModel user) {
        userRepository.insert(user);        
    }    
    
    @Override
    public UserModel getName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public String postTravelerRol(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList, String idMongo) {
        if(idMongo.equals("")) {
            String id = java.util.UUID.randomUUID().toString();
            String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
            Travel user = new Travel(id, generitToUserRolWeatherOrCategoryList);
            user.setUser(userEmail);
            user.setTravelId(id);
            travelRepository.insert(user);
            return id;
        }else{
            Travel travel = travelRepository.findUserRolSelectById(idMongo);
            travel.setUserRolList(generitToUserRolWeatherOrCategoryList);
            travelRepository.save(travel);
            return idMongo;
        }
    }

    @Override
    public void putDestinyByUserRolSelected(Country destiny, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setDestiny(destiny.getCountry());
        travelRepository.save(travel);
    }

    @Override
    public ListCategories weahterByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> weatherList, String id) {
        ListCategories listCategories = new ListCategories();
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setWeatherList(weatherList);
        String weatherName = getWeatherNaer(weatherList);
        List<String> rolName = getRolsName(travel);
        ListCategories toReturn = combinations(listCategories, weatherName, rolName);
        travelRepository.save(travel);
        return toReturn;
    }

    @Override
    public void accessoriesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> accessories, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setAccessoriesList(accessories);
        travelRepository.save(travel);
    }

    @Override
    public void onHandByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> onhand, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setOnHandList(onhand);
        travelRepository.save(travel);
    }

    @Override
    public void cleanlinessByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> cleanliness, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setCleanlinessList(cleanliness);
        travelRepository.save(travel);
    }

    @Override
    public void shoppingByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> shopping, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setShoppingList(shopping);
        travelRepository.save(travel);
    }

    @Override
    public void medicineByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> medicine, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setMedicineList(medicine);
        travelRepository.save(travel);
    }

    @Override
    public void clothesByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> clothes, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setClothesList(clothes);
        travelRepository.save(travel);
    }

    @Override
    public void severalByUserRolSelected(List<GeneritToUserRolWeatherOrCategory> several, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setSeveralList(several);
        travelRepository.save(travel);
    }

    @Override
    public void putTitleAndHour(String title, Date date, String id) {
        Travel travel = travelRepository.findUserRolSelectById(id);
        travel.setDueDate(date);
        travel.setTitle(title);
        travelRepository.save(travel);
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

    private List<String> getRolsName(Travel travel) {
        List<String> list = new ArrayList<>();
        for (GeneritToUserRolWeatherOrCategory data : travel.getUserRolList()) {
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

        List<String> accesoriesList = compareAccesories(weatherName, wetherList, pets, work, couple, backpacker, tourist);
        List<String> clothesList = compareClothes(weatherName, wetherList, pets, work, backpacker, tourist);
        List<String> cleannessList = compareCleanness(cleanness);
        List<String> healthList = compareHealth(health, work);
        List<String> onHandList = compareOnHand(onHand, pets, work);
        listCategories.setAccesoriesList(accesoriesList);
        listCategories.setClothesList(clothesList);
        listCategories.setOnHandList(onHandList);
        listCategories.setCleannessList(cleannessList);
        listCategories.setHealthList(healthList);

        return listCategories;
    }

    private List<String> compareOnHand(WeatherCategoryRol onHand, WeatherCategoryRol pets,
                                       WeatherCategoryRol work) {
        List<String> res = new ArrayList<>();

        for (String data : onHand.getOnHand()) {
            res.add(data);

        }

        if (pets != null) {
            for (String data : pets.getPetsOnHand()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (work != null) {
            for (String data : work.getWorkOnHand()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }
        return res;

    }

    private List<String> compareHealth(WeatherCategoryRol health, WeatherCategoryRol work) {
        List<String> res = new ArrayList<>();

        for (String data : health.getHealth()) {
            res.add(data);
        }

        if (work != null) {
            for (String data : work.getWorkHealth()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }

    private List<String> compareCleanness(WeatherCategoryRol cleanness) {

        List<String> res = new ArrayList<>();
        for (String data : cleanness.getCleanness()) {
            res.add(data);
        }
        return res;
    }

    private List<String> compareClothes(String weatherName, WeatherCategoryRol wetherList,
                                        WeatherCategoryRol pets, WeatherCategoryRol work,
                                        WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {
        List<String> res = new ArrayList<>();
        if (weatherName.equals("Primavera")) {
            for (String data : wetherList.getSpringClothes()) {
                res.add(data);
            }

        } else if (weatherName.equals("Verano")) {
            for (String data : wetherList.getSummerClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        } else if (weatherName.equals("Invierno")) {
            for (String data : wetherList.getWinterClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        } else {
            for (String data : wetherList.getAutumnClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (pets != null) {
            for (String data : pets.getPetsClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (work != null) {
            for (String data : work.getWorkClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (backpacker != null) {
            for (String data : backpacker.getBackpackerClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (tourist != null) {
            for (String data : tourist.getTouristClothes()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }

    public List<String> compareAccesories(String weatherName, WeatherCategoryRol wetherList, WeatherCategoryRol pets,
                                          WeatherCategoryRol work, WeatherCategoryRol couple,
                                          WeatherCategoryRol backpacker, WeatherCategoryRol tourist) {

        List<String> res = new ArrayList<>();
        if (weatherName.equals("Primavera")) {
                for (String data : wetherList.getSpringAccesories()) {
                    res.add(data);
            }
        } else if (weatherName.equals("Verano")) {
                for (String data : wetherList.getSummerAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
            }
        } else if (weatherName.equals("Invierno")) {
                for (String data : wetherList.getWinterAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                }
            }
        } else {
            if (wetherList.getAutumnAccesories() != null) {
                for (String data : wetherList.getAutumnAccesories()) {
                    if (!res.contains(data)) {
                        res.add(data);
                    }
                }
            }
        }

        if (pets != null) {
            for (String data : pets.getPetsAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (work != null) {
            for (String data : work.getWorkAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (couple != null) {
            for (String data : couple.getCoupleAcceosires()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (backpacker != null) {
            for (String data : backpacker.getBackpackerAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        if (tourist != null) {
            for (String data : tourist.getTouristAccesories()) {
                if (!res.contains(data)) {
                    res.add(data);
                }
            }
        }

        return res;

    }
    public void updateUser(String name, String email, String password, Integer phone) {
        UserModel user = userRepository.findByUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        userRepository.save(user);         
    }

    

}
