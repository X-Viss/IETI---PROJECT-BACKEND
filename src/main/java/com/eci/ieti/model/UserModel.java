package com.eci.ieti.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class UserModel {

    @Id
    private String userName;

    private String email;
    private String password;
    private Integer phone;
    private Date birth;
    private String country;

    public UserModel(String email, String userName, String password, Integer phone, Date birth, String country) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.country = country;
        this.birth = birth;
    }

    public UserModel(){
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.userName = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        this.email = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
