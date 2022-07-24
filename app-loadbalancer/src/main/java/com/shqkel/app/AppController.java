package com.shqkel.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

	@Autowired
	LoadBalancerClient loadBalancer;

	@GetMapping
	public String getHello() throws RestClientException, IOException {
		String serviceId = "APP-CLIENT1";
		ServiceInstance serviceInstance = loadBalancer.choose(serviceId);
		String baseUrl = serviceInstance.getUri().toString();
		System.out.println("baseUrl = " + baseUrl); // http://localhost:7001 http://192.168.195.1:7002 번갈아 출력

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
