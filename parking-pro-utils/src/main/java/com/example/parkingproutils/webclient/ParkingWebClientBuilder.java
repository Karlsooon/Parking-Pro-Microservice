package com.example.parkingproutils.webclient;

import com.example.paringproentity.model.dto.ParkingResponse;
import com.example.paringproentity.model.entity.Parking;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ParkingWebClientBuilder {
    private static final String baseUrl = "http://localhost:8080/api/v1/parkings/info/";

    public boolean parkingExist(Long parkingId){
        try{
            String uri = baseUrl + parkingId.toString();
            ParkingResponse parkingResponse = WebClient.create(baseUrl)
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToFlux(ParkingResponse.class)
                    .blockFirst();

            if(parkingResponse!=null){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Flux<ParkingResponse> parkingExistAsync(Long parkingId){
            String uri = baseUrl + parkingId.toString();
            Flux<ParkingResponse> parkingResponse = WebClient.create(baseUrl)
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToFlux(ParkingResponse.class);
            return parkingResponse;
    }
}
