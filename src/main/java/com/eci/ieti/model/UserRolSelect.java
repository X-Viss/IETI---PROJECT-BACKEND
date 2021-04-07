package com.eci.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "UserRol")
public class UserRolSelect {

    @Id
    private String id;
    private List<GeneritToUserRolWeatherOrCategory> userRolList;
    private List<GeneritToUserRolWeatherOrCategory> weatherList;
    private List<GeneritToUserRolWeatherOrCategory> accessoriesList;
    private List<GeneritToUserRolWeatherOrCategory> onHandList;
    private List<GeneritToUserRolWeatherOrCategory> cleanlinessList;
    private List<GeneritToUserRolWeatherOrCategory> shoppingList;
    private List<GeneritToUserRolWeatherOrCategory> medicineList;
    private List<GeneritToUserRolWeatherOrCategory> clothesList;
    private List<GeneritToUserRolWeatherOrCategory> severalList;
    private String destiny;

    public UserRolSelect() {
    }

    public UserRolSelect(String id, List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        this.id = id;
        this.userRolList = generitToUserRolWeatherOrCategoryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<GeneritToUserRolWeatherOrCategory> getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(List<GeneritToUserRolWeatherOrCategory> accessoriesList) {
        this.accessoriesList = accessoriesList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getOnHandList() {
        return onHandList;
    }

    public void setOnHandList(List<GeneritToUserRolWeatherOrCategory> onHandList) {
        this.onHandList = onHandList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getCleanlinessList() {
        return cleanlinessList;
    }

    public void setCleanlinessList(List<GeneritToUserRolWeatherOrCategory> cleanlinessList) {
        this.cleanlinessList = cleanlinessList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<GeneritToUserRolWeatherOrCategory> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<GeneritToUserRolWeatherOrCategory> medicineList) {
        this.medicineList = medicineList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<GeneritToUserRolWeatherOrCategory> clothesList) {
        this.clothesList = clothesList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getSeveralList() {
        return severalList;
    }

    public void setSeveralList(List<GeneritToUserRolWeatherOrCategory> severalList) {
        this.severalList = severalList;
    }

    public List<GeneritToUserRolWeatherOrCategory> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<GeneritToUserRolWeatherOrCategory> weatherList) {
        this.weatherList = weatherList;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public List<GeneritToUserRolWeatherOrCategory> getUserRolList() {
        return userRolList;
    }

    public void setUserRolList(List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList) {
        this.userRolList = generitToUserRolWeatherOrCategoryList;
    }
}
