package com.eci.ieti.exceptions;

public class TravelException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String USER_NOT_FOUND = "THE USER HAS NOT BEEN FOUND";

    public TravelException(String message, Exception e){
        super(message, e);
    }

    public TravelException(String message) {
    }
}
