package com.almasova.googlePlacesAPI.model.dto;

import com.almasova.googlePlacesAPI.model.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
    @Min(0)
    @Max(5)
    private double rating;
}