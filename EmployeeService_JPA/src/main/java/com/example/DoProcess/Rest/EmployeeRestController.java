package com.example.DoProcess.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DoProcess.Entity.Employee;
import com.example.DoProcess.Services.EmployeeServices;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeServices employeeServices;
	@Autowired
	public EmployeeRestController(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeServices.findAll();
	}
	@GetMapping("/employee/id/{id}")
	public Employee findById(@PathVariable int id) {
		Employee employee=employeeServices.findById(id);
		if (employee==null) {
			throw new RuntimeException("Employee not found with "+id);
		}
		return employee;
	}
	@GetMapping("/employee/name/{name}")
	public List<Employee> findByName(@PathVariable String name){
		List<Employee> list=employeeServices.findByName(name);
		if(list.isEmpty()) {
			throw new RuntimeException("Employee not found with name "+name);
		}
		return list;
	}
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		employeeServices.save(employee);
		return employee;
	}
	@DeleteMapping("/employee/id/{id}")
	public Employee delete(@PathVariable int id) {
		return employeeServices.delete(id);
	}
}
