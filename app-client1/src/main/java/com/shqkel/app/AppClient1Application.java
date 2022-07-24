package com.shqkel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppClient1Application.class, args);
	}

}