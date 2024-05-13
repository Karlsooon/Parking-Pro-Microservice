package com.example.paringproentity.model.dto;

import com.example.paringproentity.model.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
