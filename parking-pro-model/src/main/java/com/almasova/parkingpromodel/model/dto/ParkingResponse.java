package com.almasova.parkingpromodel.model.dto;

import com.almasova.parkingpromodel.model.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingResponse {
    private Long id;
    private Type type;
    private String address;
    private int capacity;
    private int current;
    private double price;
    private double latitude;
    private double longitude;
    private String owner;
    private double rating;
}
