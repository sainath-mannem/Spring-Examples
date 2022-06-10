package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.DbProperties;

@RestController
public class Controller {

	@Value("${name}")
	private String name;
	
	@Autowired
	private DbProperties dbProperties;
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello "+name;
	}
	
	@GetMapping("/hello")
	public String hello2() {
		System.out.println("dbProperties.getName(): " +dbProperties.getName());
		return "hello "+name;
	}
}
