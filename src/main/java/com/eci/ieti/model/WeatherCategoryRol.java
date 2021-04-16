package com.eci.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "WeatherCategoryRol")
public class WeatherCategoryRol {

    @Id
    private String id;
    private List<String> health;
    private List<String> cleanness;
    private List<String> onHand;
    private List<String> winterAccesories;
    private List<String> winterClothes;
    private List<String> summerAccesories;
    private List<String> summerClothes;
    private List<String> autumnAccesories;
    private List<String> autumnClothes;
    private List<String> springAccesories;
    private List<String> springClothes;
    private List<String> workAccesories;
    private List<String> workClothes;
    private List<String> workHealth;
    private List<String> workOnHand;
    private List<String> petsAccesories;
    private List<String> petsClothes;
    private List<String> petsOnHand;
    private List<String> coupleAcceosires;
    private List<String> backpackerAccesories;
    private List<String> backpackerHealth;
    private List<String> backpackerClothes;
    private List<String> touristAccesories;
    private List<String> touristClothes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getCleanness() {
        return cleanness;
    }

    public void setCleanness(List<String> cleanness) {
        this.cleanness = cleanness;
    }

    public List<String> getOnHand() {
        return onHand;
    }

    public void setOnHand(List<String> onHand) {
        this.onHand = onHand;
    }

    public List<String> getWinterAccesories() {
        return winterAccesories;
    }

    public void setWinterAccesories(List<String> winterAccesories) {
        this.winterAccesories = winterAccesories;
    }

    public List<String> getWinterClothes() {
        return winterClothes;
    }

    public void setWinterClothes(List<String> winterClothes) {
        this.winterClothes = winterClothes;
    }

    public List<String> getSummerAccesories() {
        return summerAccesories;
    }

    public void setSummerAccesories(List<String> summerAccesories) {
        this.summerAccesories = summerAccesories;
    }

    public List<String> getSummerClothes() {
        return summerClothes;
    }

    public void setSummerClothes(List<String> summerClothes) {
        this.summerClothes = summerClothes;
    }

    public List<String> getAutumnAccesories() {
        return autumnAccesories;
    }

    public void setAutumnAccesories(List<String> autumnAccesories) {
        this.autumnAccesories = autumnAccesories;
    }

    public List<String> getAutumnClothes() {
        return autumnClothes;
    }

    public void setAutumnClothes(List<String> autumnClothes) {
        this.autumnClothes = autumnClothes;
    }

    public List<String> getSpringAccesories() {
        return springAccesories;
    }

    public void setSpringAccesories(List<String> springAccesories) {
        this.springAccesories = springAccesories;
    }

    public List<String> getSpringClothes() {
        return springClothes;
    }

    public void setSpringClothes(List<String> springClothes) {
        this.springClothes = springClothes;
    }

    public List<String> getWorkAccesories() {
        return workAccesories;
    }

    public void setWorkAccesories(List<String> workAccesories) {
        this.workAccesories = workAccesories;
    }

    public List<String> getWorkClothes() {
        return workClothes;
    }

    public void setWorkClothes(List<String> workClothes) {
        this.workClothes = workClothes;
    }

    public List<String> getWorkHealth() {
        return workHealth;
    }

    public void setWorkHealth(List<String> workHealth) {
        this.workHealth = workHealth;
    }

    public List<String> getWorkOnHand() {
        return workOnHand;
    }

    public void setWorkOnHand(List<String> workOnHand) {
        this.workOnHand = workOnHand;
    }

    public List<String> getPetsAccesories() {
        return petsAccesories;
    }

    public void setPetsAccesories(List<String> petsAccesories) {
        this.petsAccesories = petsAccesories;
    }

    public List<String> getPetsClothes() {
        return petsClothes;
    }

    public void setPetsClothes(List<String> petsClothes) {
        this.petsClothes = petsClothes;
    }

    public List<String> getPetsOnHand() {
        return petsOnHand;
    }

    public void setPetsOnHand(List<String> petsOnHand) {
        this.petsOnHand = petsOnHand;
    }

    public List<String> getCoupleAcceosires() {
        return coupleAcceosires;
    }

    public void setCoupleAcceosires(List<String> coupleAcceosires) {
        this.coupleAcceosires = coupleAcceosires;
    }

    public List<String> getBackpackerAccesories() {
        return backpackerAccesories;
    }

    public void setBackpackerAccesories(List<String> backpackerAccesories) {
        this.backpackerAccesories = backpackerAccesories;
    }

    public List<String> getBackpackerHealth() {
        return backpackerHealth;
    }

    public void setBackpackerHealth(List<String> backpackerHealth) {
        this.backpackerHealth = backpackerHealth;
    }

    public List<String> getBackpackerClothes() {
        return backpackerClothes;
    }

    public void setBackpackerClothes(List<String> backpackerClothes) {
        this.backpackerClothes = backpackerClothes;
    }

    public List<String> getTouristAccesories() {
        return touristAccesories;
    }

    public void setTouristAccesories(List<String> touristAccesories) {
        this.touristAccesories = touristAccesories;
    }

    public List<String> getTouristClothes() {
        return touristClothes;
    }

    public void setTouristClothes(List<String> touristClothes) {
        this.touristClothes = touristClothes;
    }
}
