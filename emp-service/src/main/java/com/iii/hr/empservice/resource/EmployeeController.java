
package com.iii.hr.empservice.resource;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.hr.empservice.bo.Employee;
import com.iii.hr.empservice.service.EmployeeService;

//@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/dummy")
	public Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp.setAge(38);
		emp.setSalary(100000);
		emp  = employeeService.save(emp);
		return emp;
	}
	
	// /employees/24
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return employeeService.get(empId);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		return employeeService.getAllEmp();
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody @Validated Employee emp) {
		logger.info("Start createEmployee.");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp  = employeeService.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
		logger.info("Start Update.");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp.setId(empId);
		emp  = employeeService.save(emp);
		return emp;
	}
	
	@PatchMapping("/{id}")
	public Employee patchEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
		logger.info("Start Patch.");
		return employeeService.update(empId, emp);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		return employeeService.delete(empId);
	}
	
}
