package com.javadevsguide.springframework.di.service.compscan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.javadevsguide.springframework.di.config.AppConfiguration;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AppConfiguration appConfig;

	public List<String> getEmp() {
		com.javadevsguide.springframework.di.service.Service service = appConfig.service("sasa");
		return employeeRepo.getEmp();
	}
}
