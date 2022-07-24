package com.shqkel.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/")
	public String hello() {
		System.out.println("#app-client1-1");
		return "Hello World";
	}
}
