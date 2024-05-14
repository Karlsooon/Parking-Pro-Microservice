package com.example.commentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example", "com.example.commentservice"})
@EnableJpaRepositories(basePackages = {"com.example.commentservice"})
public class CommentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApplication.class, args);
    }

}
