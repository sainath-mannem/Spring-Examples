package com.iii.hr.empservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iii.hr.empservice.repo.EmployeeRepo;
import com.iii.hr.empservice.service.PreviligeCheck;

@SpringBootApplication
public class EmpServiceApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(EmpServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}

	@Value("${name}")
	private String name;
	
	@Value("${name2}")
	private String name2;
	
	@Value("${name3}")
	private String name3;
	
	@Autowired
	private PreviligeCheck check;
	
	@Override
	public void run(String... args) throws Exception {

		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		check.isUserHasAccess("");
	}

}
