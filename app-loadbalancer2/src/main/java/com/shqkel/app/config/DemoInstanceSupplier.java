package com.shqkel.app.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import reactor.core.publisher.Flux;

public class DemoInstanceSupplier implements ServiceInstanceListSupplier {
    private final String serviceId;

    public DemoInstanceSupplier(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
    	/*
    	 * org.springframework.cloud.client.DefaultServiceInstance.DefaultServiceInstance(
    	 * 	String instanceId, 	// the id of the instance
    	 * 	String serviceId, 	// the id of the service
    	 *  String host, 		// the host where the service instance can be found
    	 *  int port, 			// the port on which the service is running
    	 *  boolean secure)		// indicates whether or not the connection needs to be secure.
    	 * 
    	 * 
    	 */
        return Flux.just(
        		Arrays.asList(
        				new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 7003, false),
        				new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 7004, false)));
    }
}