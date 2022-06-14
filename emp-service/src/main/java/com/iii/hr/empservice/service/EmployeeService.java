package com.iii.hr.empservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.iii.hr.empservice.bo.Employee;
import com.iii.hr.empservice.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee save(Employee emp) {
		Employee emp2 = employeeRepo.save(emp);
		return emp2;
	}

	public Employee get(int empId) {
		return employeeRepo.get(empId);
	}

	public List<Employee> getAllEmp() {
		return employeeRepo.getAllEmp();
	}

	public Employee update(int empId, Employee updated) {

		Employee saved = employeeRepo.get(empId);
		updated.setLastUpdatedDate(LocalDate.now().toString());
		updated.setId(empId);
		if(updated.getSalary() == 0) {
			updated.setSalary(saved.getSalary());
		}
		if(updated.getAge() == 0) {
			updated.setAge(saved.getAge());
		}
		if(!StringUtils.hasLength(updated.getName())) {
			updated.setName(saved.getName());
		}
		return employeeRepo.save(updated);
	}

	public Employee delete(int empId) {
		return employeeRepo.delete(empId);
	}

}
