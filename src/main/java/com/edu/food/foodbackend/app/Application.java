package com.edu.food.foodbackend.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Entity;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.edu.food.foodbackend.controller", "com.edu.food.foodbackend.entity"})
@EnableJpaRepositories(basePackages = {"com.edu.food.foodbackend.repository"})
@EntityScan(basePackages = {"com.edu.food.foodbackend.entity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
