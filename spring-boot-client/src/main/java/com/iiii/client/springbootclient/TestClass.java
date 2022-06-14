package com.iiii.client.springbootclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestClass {

	public static void main(String[] args) {
		RestTemplate client = new RestTemplate();
		Employee emp = new Employee(101, "Sai2", 39, 11111111);
		ResponseEntity<Employee> postForEntity = client.postForEntity("http://localhost:8080/employees", emp, Employee.class);
		System.out.println("Status" + postForEntity.getStatusCodeValue());
		System.out.println("Employee" + postForEntity.getBody());
	}
}
