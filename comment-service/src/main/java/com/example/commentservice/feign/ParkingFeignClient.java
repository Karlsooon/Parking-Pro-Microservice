package com.example.commentservice.feign;

import com.example.paringproentity.model.dto.ParkingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "parking-service", url = "http://localhost:8080/api/v1/parkings")
public interface ParkingFeignClient {
    @GetMapping("/info/{id}")
    ParkingResponse getParking(@PathVariable Long id);
}
