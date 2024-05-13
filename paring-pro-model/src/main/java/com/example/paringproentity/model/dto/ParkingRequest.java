package com.example.paringproentity.model.dto;

import com.example.paringproentity.model.enums.Type;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingRequest {
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