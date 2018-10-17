package com.lt5.foodmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FoodManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodManageApplication.class, args);
	}
}
