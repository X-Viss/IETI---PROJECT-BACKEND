package com.eci.ieti.controller;

import com.eci.ieti.model.Country;
import com.eci.ieti.model.GeneritToUserRolWeatherOrCategory;
import com.eci.ieti.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/create")
public class CreateTripController {

    @Autowired
    private TravelService travelService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "rol")
    public ResponseEntity<String> postSelectTravelerRol(@RequestBody List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList, @RequestParam("id") String id) {
        return new ResponseEntity<>(travelService.postTravelerRol(generitToUserRolWeatherOrCategoryList, id), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "destiny")
    public ResponseEntity<Country> putDestinyByUserRolSelected(@RequestBody Country destiny, @RequestParam("id") String id) {
        travelService.putDestinyByUserRolSelected(destiny, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "titlehour")
    public ResponseEntity<Country> putTitleAndHour(@RequestParam("title") String title, @RequestParam("date") String date, @RequestParam("id") String id) throws ParseException {
        String newDate = date.replace("T"," ");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date toDate = formato.parse(newDate);
        travelService.putTitleAndHour(title, toDate, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "weather")
    public ResponseEntity<Object> putWeatherByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> weatherList, @RequestParam("id") String id) {
        return new ResponseEntity<>(travelService.putWeahterByUserRolSelected(weatherList, id),HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/accessories")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putAccessoriesByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> accessories, @RequestParam("id") String id) {
        travelService.putAccessoriesByUserRolSelected(accessories, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/onhand")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putOnHandByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> onhand, @RequestParam("id") String id) {
        travelService.putOnHandByUserRolSelected(onhand, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/cleanliness")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putCleanlinessByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> cleanliness, @RequestParam("id") String id) {
        travelService.putCleanlinessByUserRolSelected(cleanliness, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/shopping")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putShoppingByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> shopping, @RequestParam("id") String id) {
        travelService.putShoppingByUserRolSelected(shopping, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/medicine")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putMedicineByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> medicine, @RequestParam("id") String id) {
        travelService.putMedicineByUserRolSelected(medicine, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/clothes")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putClothesByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> clothes, @RequestParam("id") String id) {
        travelService.putClothesByUserRolSelected(clothes, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "category/several")
    public ResponseEntity<GeneritToUserRolWeatherOrCategory> putSeveralByUserRolSelected(@RequestBody List<GeneritToUserRolWeatherOrCategory> several, @RequestParam("id") String id) {
        travelService.putSeveralByUserRolSelected(several, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
