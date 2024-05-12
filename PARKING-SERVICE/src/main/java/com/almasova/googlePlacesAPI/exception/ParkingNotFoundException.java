package com.almasova.googlePlacesAPI.exception;

public class ParkingNotFoundException extends RuntimeException{

    public  ParkingNotFoundException(Long id){
        super("Parking with id %s not found".formatted(id));
    }
}
