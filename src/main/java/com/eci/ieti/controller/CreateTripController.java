package com.eci.ieti.controller;

import com.eci.ieti.model.Country;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/create")
public class CreateTripController {

    @Autowired
    private TravelService travelService;

    @PostMapping(value = "rol")
    public ResponseEntity<?> postSelectTravelerRol(@RequestBody List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        return new ResponseEntity<>(travelService.postTravelerRol(generitToUserRolWeatherOrCategoryList), HttpStatus.CREATED);
    }

    @PutMapping(value = "destiny")
    public ResponseEntity<?> putDestinyByUserRolSelected(@RequestBody Country destiny, @RequestParam("id") String id) {
        travelService.putDestinyByUserRolSelected(destiny, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "weather")
    public ResponseEntity<?> putWeatherByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> weatherList, @RequestParam("id") String id) {
        return new ResponseEntity<>(travelService.putWeahterByUserRolSelected(weatherList, id),HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/accessories")
    public ResponseEntity<?> putAccessoriesByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> accessories, @RequestParam("id") String id) {
        travelService.putAccessoriesByUserRolSelected(accessories, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/onhand")
    public ResponseEntity<?> putOnHandByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> onhand, @RequestParam("id") String id) {
        travelService.putOnHandByUserRolSelected(onhand, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/cleanliness")
    public ResponseEntity<?> putCleanlinessByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> cleanliness, @RequestParam("id") String id) {
        travelService.putCleanlinessByUserRolSelected(cleanliness, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/shopping")
    public ResponseEntity<?> putShoppingByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> shopping, @RequestParam("id") String id) {
        travelService.putShoppingByUserRolSelected(shopping, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/medicine")
    public ResponseEntity<?> putMedicineByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> medicine, @RequestParam("id") String id) {
        travelService.putMedicineByUserRolSelected(medicine, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/clothes")
    public ResponseEntity<?> putClothesByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> clothes, @RequestParam("id") String id) {
        travelService.putClothesByUserRolSelected(clothes, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "category/several")
    public ResponseEntity<?> putSeveralByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> several, @RequestParam("id") String id) {
        travelService.putSeveralByUserRolSelected(several, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
