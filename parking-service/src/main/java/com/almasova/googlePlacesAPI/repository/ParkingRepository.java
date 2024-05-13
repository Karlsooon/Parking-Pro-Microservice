package com.almasova.googlePlacesAPI.repository;

import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
     Parking findByLatitudeAndLongitude(double latitude, double longitude);


}
