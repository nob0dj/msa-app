package com.shqkel.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
@EnableEurekaClient
public class AppLoadbalancerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext context = SpringApplication.run(AppLoadbalancerApplication.class, args);
		AppController appController = context.getBean(AppController.class);

		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " : " + appController.getHello());
		}

	}

}
