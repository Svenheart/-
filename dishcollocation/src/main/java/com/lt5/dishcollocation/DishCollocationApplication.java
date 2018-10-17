package com.lt5.dishcollocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DishCollocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DishCollocationApplication.class, args);
	}
}
