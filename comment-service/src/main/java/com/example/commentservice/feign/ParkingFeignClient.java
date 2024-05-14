package com.example.commentservice.feign;

import com.example.paringproentity.model.dto.ParkingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "parking-service", url = "http://localhost:8080/api/v1/parkings", fallback = ParkingFeignClientFallback.class)
@Component
public interface ParkingFeignClient {
    @GetMapping("/info/{id}")
    ResponseEntity<ParkingResponse> getParking(@PathVariable Long id);
}
@Component
class ParkingFeignClientFallback implements ParkingFeignClient{

    @Override
    public ResponseEntity<ParkingResponse> getParking(Long id) {
        return null;
    }
}
