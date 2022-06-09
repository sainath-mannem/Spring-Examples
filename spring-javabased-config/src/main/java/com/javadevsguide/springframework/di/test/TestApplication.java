package com.javadevsguide.springframework.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javadevsguide.springframework.di.config.AppConfiguration;
import com.javadevsguide.springframework.di.service.Controller;
import com.javadevsguide.springframework.di.service.MessageProcessor;
import com.javadevsguide.springframework.di.service.ServiceImpl;
import com.javadevsguide.springframework.di.service.compscan.EmployeeController;

public class TestApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MessageProcessor  userService = applicationContext.getBean(MessageProcessor.class);
		userService.processMsg("twitter message sending ");
		
		Controller controller = applicationContext.getBean(Controller.class);
		
		System.out.println(controller);
		
		Controller controller2 = applicationContext.getBean(Controller.class);
		
		System.out.println(controller2);
		
		System.out.println(controller.getService());
		System.out.println(controller2.getService());
		
		System.out.println(controller.getIds());
		
		System.out.println(applicationContext.getBean(EmployeeController.class).getEmp());
		
		ServiceImpl se = new ServiceImpl("2");
		ServiceImpl se2 = (ServiceImpl)applicationContext.getBean("service1");
		se.getIds();
		se2.getIds();
		
		
	}
}
