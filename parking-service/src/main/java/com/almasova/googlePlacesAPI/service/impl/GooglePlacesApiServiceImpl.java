package com.almasova.googlePlacesAPI.service.impl;


import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import com.almasova.googlePlacesAPI.service.GooglePlacesApiService;

import com.example.paringproentity.mapper.ParkingMapper;
import com.example.paringproentity.model.dto.ParkingRequest;
import com.example.paringproentity.model.entity.Parking;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GooglePlacesApiServiceImpl implements GooglePlacesApiService {
    private final ParkingMapper parkingMapper;
    private final ParkingRepository parkingRepository;
    @Value("${google.api}")
    private String apiKey;
    public List<LatLong> latLongList;
    private final String GOOGLE_PLACES_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private final String CREATE_PLACES_API_URL = "http://localhost:8080/api/v1/parkings/create";
    public List<LatLong> getParkingLocations(double latitude, double longitude, int radius){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = String.format("%s?location=%f,%f&radius=%d&types=parking&key=%s",
                GOOGLE_PLACES_API_URL, latitude, longitude, radius, apiKey);
        latLongList = new ArrayList<>();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);
        JSONArray results = jsonObject.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            JSONObject result = results.getJSONObject(i);
            JSONObject location = result.getJSONObject("geometry").getJSONObject("location");
//            String name = result.getString("name");
//            System.out.println("-------------------------------------------------------------"+name+"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            double lat = location.getDouble("lat");
            double lng = location.getDouble("lng");
            latLongList.add(new LatLong(lat, lng));
        }

        for (LatLong latLong : latLongList) {
            double lat = latLong.lat;
            double lng = latLong.lng;
            String url2 = CREATE_PLACES_API_URL;

            ParkingRequest parkingRequest = new ParkingRequest();
            parkingRequest.setLatitude(lat);
            parkingRequest.setLongitude(lng);
            HttpEntity<ParkingRequest> requestEntity = new HttpEntity<>(parkingRequest, headers);

            Parking parking = restTemplate.postForObject(url2, requestEntity, Parking.class);
        }
        return latLongList;
    }

    public static class LatLong{
        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lng")
        private double lng;

        public LatLong(double lat, double lng){
            this.lat=lat;
            this.lng=lng;
        }
    }
}
