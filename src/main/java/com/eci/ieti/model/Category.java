package com.eci.ieti.model;

import java.util.List;

public class Category {

    private String title;
    private List<Elements> elementsList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Elements> getElementsList() {
        return elementsList;
    }

    public void setElementsList(List<Elements> elementsList) {
        this.elementsList = elementsList;
    }
}
