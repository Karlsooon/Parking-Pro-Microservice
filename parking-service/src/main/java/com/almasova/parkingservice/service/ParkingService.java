package com.almasova.parkingservice.service;


import com.almasova.parkingpromodel.model.dto.ParkingRequest;
import com.almasova.parkingpromodel.model.dto.ParkingResponse;
import com.almasova.parkingpromodel.model.entity.Parking;

import java.util.List;
public interface ParkingService {
    List<ParkingResponse> getAllParkings();
    ParkingResponse getParking(Long id);
    Parking createParking(ParkingRequest parkingRequest);
    Parking get(Long id);
    Parking updateParking(ParkingRequest parkingRequest, Long id);
    void deleteParking(Long id);

}
