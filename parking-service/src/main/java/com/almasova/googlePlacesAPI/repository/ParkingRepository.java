package com.almasova.googlePlacesAPI.repository;

import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
     Optional<Parking> findByLatitudeAndLongitude(double latitude, double longitude);
}
