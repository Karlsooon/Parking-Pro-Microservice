package com.almasova.googlePlacesAPI.repository;

import com.almasova.googlePlacesAPI.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GooglePlacesApiRepository extends JpaRepository<Parking, Long> {
}
