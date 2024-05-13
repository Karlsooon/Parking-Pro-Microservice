package com.almasova.googlePlacesAPI.service;


import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.dto.ParkingRequest;
import com.example.paringproentity.model.dto.ParkingResponse;
import com.example.paringproentity.model.entity.Parking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ParkingService {
    List<ParkingResponse> getAllParkings();
    ParkingResponse getParking(Long id);
    Parking createParking(ParkingRequest parkingRequest);
    Parking get(Long id);
    Parking updateParking(ParkingRequest parkingRequest, Long id);
    void deleteParking(Long id);

}
