package com.iii.hr.empservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}

	@Value("${name}")
	private String name;
	
	@Value("${name2}")
	private String name2;
	
	@Value("${name3}")
	private String name3;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("name: "+name);
		System.out.println("name2: "+name2);
		System.out.println("name3: "+name3);
	}

}
