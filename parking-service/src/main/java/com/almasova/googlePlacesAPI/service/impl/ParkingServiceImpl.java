package com.almasova.googlePlacesAPI.service.impl;

import com.almasova.googlePlacesAPI.exception.ParkingNotFoundException;

import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import com.almasova.googlePlacesAPI.service.ParkingService;
import com.example.paringproentity.mapper.ParkingMapper;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.dto.ParkingRequest;
import com.example.paringproentity.model.dto.ParkingResponse;
import com.example.paringproentity.model.entity.Parking;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Parking> hasParking = parkingRepository.findByLatitudeAndLongitude(lat, lng);

        if (hasParking.isPresent()) {
            return null;
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
