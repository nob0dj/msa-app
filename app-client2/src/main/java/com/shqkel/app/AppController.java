package com.shqkel.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/")
	public String hello() {
		System.out.println("Byebye World");
		return "Byebye World";
	}
}
