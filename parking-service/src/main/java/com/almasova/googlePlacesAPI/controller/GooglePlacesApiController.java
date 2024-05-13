package com.almasova.googlePlacesAPI.controller;

import com.almasova.googlePlacesAPI.service.GooglePlacesApiService;
import com.almasova.googlePlacesAPI.service.impl.GooglePlacesApiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/nearest")
public class GooglePlacesApiController {
    private final GooglePlacesApiService service;
    List<GooglePlacesApiServiceImpl.LatLong> latLongList;

    @GetMapping
    public ResponseEntity<List<GooglePlacesApiServiceImpl.LatLong>> getAll(@RequestParam double latitude,
                                                           @RequestParam double longitude,
                                                           @RequestParam int radius){
        latLongList= service.getParkingLocations(latitude,longitude,radius);
        return ResponseEntity.ok(latLongList);
    }
}
