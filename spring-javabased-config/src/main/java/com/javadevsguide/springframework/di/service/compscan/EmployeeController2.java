package com.javadevsguide.springframework.di.service.compscan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController2 {

	@Autowired
	private EmployeeService empService;
	
	
	//@getmapping
	public List<String> getEmp() {
		return empService.getEmp();
	}
}
