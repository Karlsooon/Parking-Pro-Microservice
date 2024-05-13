package com.almasova.parkingservice.service.impl;

import com.almasova.parkingservice.exception.ParkingNotFoundException;

import com.almasova.parkingservice.repository.ParkingRepository;
import com.almasova.parkingservice.service.ParkingService;
import com.almasova.parkingpromodel.mapper.ParkingMapper;
import com.almasova.parkingpromodel.model.dto.ParkingRequest;
import com.almasova.parkingpromodel.model.dto.ParkingResponse;
import com.almasova.parkingpromodel.model.entity.Parking;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {
    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;

    @Override
    public List<ParkingResponse> getAllParkings(){
        List<ParkingResponse> parkingResponses = parkingMapper.toParkingResponseList(parkingRepository.findAll());

        return parkingResponses;
    }
    @Override
    public ParkingResponse getParking(Long id){
        Parking parking = get(id);
        ParkingResponse parkingResponse = parkingMapper.toParkingResponse(parking);
        return parkingResponse;
    }

    @Override
    public Parking createParking(ParkingRequest parkingRequest){
        double lat = parkingRequest.getLatitude();
        double lng = parkingRequest.getLongitude();
        Parking hasParking = parkingRepository.findByLatitudeAndLongitude(lat, lng);

        if (hasParking != null) {
            return null; // Parking already exists
        } else {
            log.info("Creating new parking");
            Parking parking = parkingMapper.toParking(parkingRequest);
            return parkingRepository.save(parking);
        }
    }
    @Override
    public Parking updateParking(ParkingRequest parkingRequest, Long id){
        Parking existingParking = get(id);
        Parking updatesParking = parkingMapper.toParking(parkingRequest);
        updatesParking.setId(existingParking.getId());
        return parkingRepository.save(updatesParking);

    }
    @Override
    public void deleteParking(Long id){
        parkingRepository.deleteById(id);
    }
    @Override
    public Parking get(Long id){
        return parkingRepository.findById(id).orElseThrow(()->new ParkingNotFoundException(id));
    }



    //getParking
    //createParking
    //updateParking
    //deleteParking
}
