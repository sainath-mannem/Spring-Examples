package com.javadevsguide.springframework.di.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.javadevsguide.springframework.di.service.compscan.EmployeeRepo;

public class ServiceImpl implements Service, InitializingBean, DisposableBean {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public ServiceImpl(String id) {
		
	}

	public ServiceImpl() {
	}

	@Override
	public List<String> getIds() {
		System.out.println("employeeRepo: "+employeeRepo);
		return Arrays.asList("A", "B");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After ini employeeRepo"+employeeRepo);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Before Destroy");
	}

}
