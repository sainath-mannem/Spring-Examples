package com.iiii.client.springbootclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-client")
public class Controller {

	
	@GetMapping
	public String test() {
		
		return "Success";
	}
}
