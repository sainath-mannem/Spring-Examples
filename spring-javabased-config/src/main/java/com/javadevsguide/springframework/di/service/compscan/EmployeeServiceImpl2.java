package com.javadevsguide.springframework.di.service.compscan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeServiceImpl2")
public class EmployeeServiceImpl2 implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public List<String> getEmp() {
		return employeeRepo.getEmp();
	}
}
