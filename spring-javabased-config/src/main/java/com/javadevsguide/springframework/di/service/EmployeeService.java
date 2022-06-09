package com.javadevsguide.springframework.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public List<String> getEmp() {
		return employeeRepo.getEmp();
	}
}
