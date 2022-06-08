package com.javadevsguide.springframework.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

	public Service getService() {
		return service;
	}

	@Autowired
	private Service service;

	/*@Autowired
	public Controller(Service service) {
		this.service = service;
	}*/
	
	

	public List<String> getIds() {
		return service.getIds();
	}

	/*
	 * public void setService(Service service) { this.service = service; }
	 */
}
