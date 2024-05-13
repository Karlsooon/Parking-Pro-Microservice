package com.almasova.googleplacesapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.almasova.parkingpromodel", "com.almasova.googleplacesapiservice"})
@EnableJpaRepositories(basePackages = {"com.almasova.googleplacesapiservice"})

public class GooglePlacesApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GooglePlacesApiServiceApplication.class, args);
    }

}
