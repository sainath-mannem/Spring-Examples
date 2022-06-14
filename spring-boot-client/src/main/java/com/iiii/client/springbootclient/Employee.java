
package com.iiii.client.springbootclient;

import java.io.Serializable;

public class Employee implements Serializable{

	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	private static final long serialVersionUID = -7788619177798333712L;
	
	private int id;
	private String name;
	private int age;
	private double salary;
	private String lastUpdatedDate;
	
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
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
	
	
}
