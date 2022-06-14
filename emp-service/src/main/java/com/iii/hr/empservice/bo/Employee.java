
package com.iii.hr.empservice.bo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Employee implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	@NotNull
	private int id;
	@NotNull
	private String name;
	private String lastUpdatedDate;
	@NotNull
	@Min(value = 1, message = "Id can't be less than 1 or bigger than 120")
	@Max(120)
	private int age;
	@NotNull
	private double salary;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		return;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	
}
