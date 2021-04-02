package com.eci.ieti.exceptions.persistence;

public class TravelPersistenceException extends Exception{

    public static String USER_NOT_FOUND = "THE USER HAS NOT BEEN FOUND";

    public TravelPersistenceException(String message){
        super(message);
    }

    public TravelPersistenceException(String message, Exception e){
        super(message, e);
    }
}
