package com.example.DoProcess.Services;

import java.util.List;

import com.example.DoProcess.Entity.Employee;

public interface EmployeeServices {

public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public List<Employee> findByName(String name);
	
	public Employee save(Employee employee);
	
	public Employee delete(int id);
}
