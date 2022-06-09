package com.javadevsguide.springframework.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.javadevsguide.springframework.di.service.Controller;
import com.javadevsguide.springframework.di.service.EmailService;
import com.javadevsguide.springframework.di.service.MessageService;
import com.javadevsguide.springframework.di.service.SMSService;
import com.javadevsguide.springframework.di.service.Service;
import com.javadevsguide.springframework.di.service.ServiceImpl;

@Configuration
@ComponentScan("com.javadevsguide.springframework.di")
@Import(AppConfiguration2.class)
public class AppConfiguration {

	@Bean(name="emailService")
	public MessageService emailService(){
		return new EmailService();
	}
	
	@Bean(name="smsService")
	public MessageService smsService(){
		return new SMSService();
	}
	
	@Bean
	//@Scope("prototype")
	public Controller controller(){
		//return new Controller(new ServiceImpl());
		//Controller controller = new Controller();
		//controller.setService(new ServiceImpl());
		//return controller;
		return new Controller();
	}
	
	@Bean
	@Scope("prototype")
	public Service service(){
		return new ServiceImpl();
	}
	
	@Bean
	@Scope("prototype")
	public Service service(String id){
		return new ServiceImpl(id);
	}
	
	@Bean
	@Lazy
	public Service service1(){
		return new ServiceImpl("2");
	}
	
	/*@Bean
	@Scope("prototype")
	public Service service2(String id){
		return new ServiceImpl("3");
	}
	
	@Bean
	@Scope("prototype")
	public Service service4(String id){
		return new ServiceImpl("4");
	}*/
	
}
