package com.almasova.parkingservice.repository;

import com.almasova.parkingpromodel.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
     Parking findByLatitudeAndLongitude(double latitude, double longitude);


}
