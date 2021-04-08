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

    public UserModel(String email, String userName, String password, Integer phone, Date birth) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
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
    }

}
