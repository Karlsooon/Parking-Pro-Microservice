package com.almasova.googleplacesapiservice.service;



import com.almasova.googleplacesapiservice.service.impl.GooglePlacesApiServiceImpl;

import java.util.List;

public interface GooglePlacesApiService {
    public List<GooglePlacesApiServiceImpl.LatLong> getParkingLocations(double latitude, double longitude, int radius);

}
