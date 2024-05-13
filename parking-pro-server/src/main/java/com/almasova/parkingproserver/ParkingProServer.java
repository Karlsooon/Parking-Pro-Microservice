package com.almasova.parkingproserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class ParkingProServer {

	public static void main(String[] args) {
		SpringApplication.run(ParkingProServer.class, args);
	}

}
