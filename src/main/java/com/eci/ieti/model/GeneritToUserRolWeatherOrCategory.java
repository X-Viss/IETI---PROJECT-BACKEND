package com.eci.ieti.model;

public class GeneritToUserRolWeatherOrCategory {

    public boolean check;
    public String name;
    public String path;

    public GeneritToUserRolWeatherOrCategory(){}

    public GeneritToUserRolWeatherOrCategory(boolean check, String name, String path) {
        this.check = check;
        this.name = name;
        this.path = path;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
