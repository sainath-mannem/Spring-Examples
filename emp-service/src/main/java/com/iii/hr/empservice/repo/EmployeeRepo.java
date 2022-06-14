package com.iii.hr.empservice.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iii.hr.empservice.bo.Employee;


@Repository
public class EmployeeRepo {
	
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	public Employee save(Employee emp) {
		return empData.put(emp.getId(), emp);
	}

	public Employee get(int empId) {
		return empData.get(empId);
	}

	public List<Employee> getAllEmp() {
		return new ArrayList<Employee>(empData.values());
	}

	public Employee delete(int empId) {
		return empData.remove(empId);
	}

}
