package com.javadevsguide.springframework.di.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {

	public List<String> getEmp() {
		return Arrays.asList("Sainath");
	}

}
