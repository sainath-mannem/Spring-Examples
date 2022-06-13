
package com.iii.hr.empservice.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iii.hr.empservice.bo.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	@GetMapping("/dummy")
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp.setAge(38);
		emp.setSalary(100000);
		empData.put(9999, emp);
		return emp;
	}
	
	// /employees/24
	@GetMapping("/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return empData.get(empId);
	}
	
	@GetMapping
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	
	@PostMapping
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody Employee updateEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
		logger.info("Start Update.");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp.setId(empId);
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@PatchMapping("/{id}")
	public @ResponseBody Employee patchEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
		logger.info("Start Patch.");
		emp.setLastUpdatedDate(LocalDate.now().toString());
		emp.setId(empId);
		if(emp.getSalary() == 0) {
			emp.setSalary(empData.get(emp.getId()).getSalary());
		}
		if(emp.getAge() == 0) {
			emp.setAge(empData.get(emp.getId()).getAge());
		}
		if(!StringUtils.hasLength(emp.getName())) {
			emp.setName(empData.get(emp.getId()).getName());
		}
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
}
