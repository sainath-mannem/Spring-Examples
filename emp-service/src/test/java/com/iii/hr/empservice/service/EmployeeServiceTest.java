package com.iii.hr.empservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.iii.hr.empservice.repo.EmployeeRepo;

@SpringBootTest
public class EmployeeServiceTest {

	private EmployeeRepo employeeRepo = Mockito.mock(EmployeeRepo.class);
	
	@InjectMocks
	private EmployeeService employeeService;
	
	int empId = 12;
	
	@Test
	void test_totalExpGreaterThan10AndCurrExpGreater3() {
		//Mockito.when(employeeRepo.getTotalExp(empId)).thenReturn(11);
		Mockito.doReturn(11).when(employeeRepo).getTotalExp(empId);
		Mockito.when(employeeRepo.getCurrentCompanyExp(empId)).thenCallRealMethod();
		assertEquals(30, employeeService.calculateHikePercentage(empId));
	}
	
	@Test
	void test_totalExpGreaterThan10AndCurrExplessthan3() {
		//Mockito.when(employeeRepo.getTotalExp(empId)).thenReturn(11);
		Mockito.doReturn(11).when(employeeRepo).getTotalExp(empId);
		Mockito.when(employeeRepo.getCurrentCompanyExp(empId)).thenReturn(2);
		assertEquals(20, employeeService.calculateHikePercentage(empId));
	}
}
