package com.almasova.googlePlacesAPI.service;


import com.almasova.googlePlacesAPI.service.impl.GooglePlacesApiServiceImpl;

import java.util.List;

public interface GooglePlacesApiService {
    public List<GooglePlacesApiServiceImpl.LatLong> getParkingLocations(double latitude, double longitude, int radius);

}
