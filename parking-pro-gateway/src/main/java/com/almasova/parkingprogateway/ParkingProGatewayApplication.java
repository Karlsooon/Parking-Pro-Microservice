package com.almasova.parkingprogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ParkingProGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkingProGatewayApplication.class, args);
	}

}
