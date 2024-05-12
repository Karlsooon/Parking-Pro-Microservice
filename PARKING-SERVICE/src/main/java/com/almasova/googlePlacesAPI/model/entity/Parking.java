package com.almasova.googlePlacesAPI.model.entity;

import com.almasova.googlePlacesAPI.model.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="parking")
public class Parking {
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
    @OneToMany(mappedBy = "parking")
    private List<Comment> commentList;
}
