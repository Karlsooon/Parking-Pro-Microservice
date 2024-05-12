package com.almasova.googlePlacesAPI.controller;

import com.almasova.googlePlacesAPI.model.dto.ParkingRequest;
import com.almasova.googlePlacesAPI.model.dto.ParkingResponse;
import com.almasova.googlePlacesAPI.model.entity.Parking;
import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import com.almasova.googlePlacesAPI.service.ParkingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/parkings")
@RequiredArgsConstructor

public class ParkingController {
    private final ParkingService parkingService;
    @GetMapping
    public ResponseEntity<List<ParkingResponse>> getAllParkings(){
        return ResponseEntity.ok(parkingService.getAllParkings());
    }
    @GetMapping("/info/{id}")
    public ResponseEntity<ParkingResponse> getParking(@PathVariable Long id){
        return ResponseEntity.ok(parkingService.getParking(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Parking> createParking(@RequestBody @Valid ParkingRequest parkingRequest){

        return ResponseEntity.ok(parkingService.createParking(parkingRequest));
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Parking> updateParking(@PathVariable Long id, @RequestBody ParkingRequest parkingRequest){
        return ResponseEntity.ok(parkingService.updateParking(parkingRequest, id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParking(@PathVariable Long id){
        parkingService.deleteParking(id);
        return ResponseEntity.ok("Parking with id: " + id + " was deleted");
    }
}
