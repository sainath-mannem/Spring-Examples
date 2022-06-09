package com.javadevsguide.springframework.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	
	//@getmapping
	public List<String> getEmp() {
		return empService.getEmp();
	}
}
