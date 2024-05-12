package com.almasova.googlePlacesAPI.model.dto;

import com.almasova.googlePlacesAPI.model.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String address;
    private int capacity;
    private int current;
    private double price;
    private double latitude;
    private double longitude;
    private String owner;
    private double rating;
    private List<CommentResponse> commentResponseList;
}
