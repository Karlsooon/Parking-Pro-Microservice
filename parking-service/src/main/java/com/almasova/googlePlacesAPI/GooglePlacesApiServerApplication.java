package com.almasova.googlePlacesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example.paringproentity", "com.almasova"})
@EnableJpaRepositories(basePackages = {"com.almasova.googlePlacesAPI"})

public class GooglePlacesApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GooglePlacesApiServerApplication.class, args);
    }

}