package com.javadevsguide.springframework.di.service.compscan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController4 {

	@Autowired
	@Qualifier("employeeServiceImpl2")
	private EmployeeService empService;
	
	
	//@getmapping
	public List<String> getEmp() {
		return empService.getEmp();
	}
}
