package com.iii.hr.empservice.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.iii.hr.empservice.bo.Employee;


@Repository
public class EmployeeRepo {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeRepo.class);
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	public Employee save(Employee emp) {
		empData.put(emp.getId(), emp);
		return emp;
	}

	public Employee get(int empId) {
		return empData.get(empId);
	}

	public List<Employee> getAllEmp() {
		logger.debug("Entered getAllEmp");
		return new ArrayList<Employee>(empData.values());
	}

	public Employee delete(int empId) {
		return empData.remove(empId);
	}

	public int getTotalExp(int empid) {
		return 2;
	}

	public int getCurrentCompanyExp(int empid) {
		// TODO Auto-generated method stub
		return 3;
	}

}
