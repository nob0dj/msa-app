package com.shqkel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class AppLoadbalancer2Application {

	public static void main(String[] args) {

		SpringApplication.run(AppLoadbalancer2Application.class, args);
		
//		ConfigurableApplicationContext context = 
//				new SpringApplicationBuilder(AppLoadbalancer2Application.class)
//						.web(WebApplicationType.NONE)
//						.run(args);
//
//		WebClient loadBalancedClient = context.getBean(WebClient.Builder.class).build();
//
//		for (int i = 1; i <= 10; i++) {
//			String response = loadBalancedClient.get().uri("http://app-client2").retrieve()
//					.toEntity(String.class).block().getBody();
//			System.out.println(response);
//		}
	}
}
