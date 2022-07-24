package com.shqkel.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bye")
public class AppController {

	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		return String.format("Bye, %s", name);
	}
}
