package com.eci.ieti.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "UserRol")
public class UserRolSelect {

    public String id;
    public List<UserRol> userRolList;

    public UserRolSelect() {}

    public UserRolSelect(String id, List<UserRol> userRolList) {
        this.id = id;
        this.userRolList = userRolList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserRol> getUserRolList() {
        return userRolList;
    }

    public void setUserRolList(List<UserRol> userRolList) {
        this.userRolList = userRolList;
    }
}
