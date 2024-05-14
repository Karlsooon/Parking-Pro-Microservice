package com.example.parkingproutils.resttemplate;

import com.example.paringproentity.model.dto.ParkingResponse;
import com.example.paringproentity.model.entity.Parking;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;

@Component
public class ParkingRestBuilder {
    private static final String baseUrl = "http://localhost:8080/api/v1/parkings/info/";

    public boolean parkingExist(Long parkingId){
        RestTemplate restTemplate= new RestTemplate();
        HttpEntity<Long> request = new HttpEntity<>(parkingId);

        ResponseEntity<ParkingResponse> response = null;

        try{
            response=restTemplate.exchange(baseUrl+parkingId, HttpMethod.GET, request, ParkingResponse.class);
            if(response.getStatusCode() == HttpStatus.OK){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
