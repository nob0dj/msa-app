package com.shqkel.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AppController {

	@Autowired
	ApplicationContext context;

	@GetMapping
	public String getByebye() {
		WebClient loadBalancedClient = context.getBean(WebClient.Builder.class).build();
		return loadBalancedClient
				.get()
				.uri("http://app-client2")
				.retrieve()
				.toEntity(String.class)
				.block()
				.getBody();
	}

}
