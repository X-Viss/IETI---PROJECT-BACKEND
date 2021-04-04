package com.eci.ieti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Travel")
public class Travel {

    @Id
    @JsonIgnore
    private String id;

    private String travelId;
    private String title;
    private String description;
    private String lugar;
    private Date dueDate;
    private String user;
    private List<Category> category;

    public String getTravelId() {
        return travelId;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }



    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("[ title:  %s, description: %s, lugar: %s, user: %s ]", this.title, this.description, this.lugar, this.user);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Travel travel = (Travel) obj;
            return getTitle().equals(travel.getTitle()) &&
                    getTravelId().equals(travel.travelId) &&
                    getLugar().equals(travel.lugar) &&
                    getUser().equals(travel.getUser());
        } catch (Exception e) {
            return false;
        }
    }
}
