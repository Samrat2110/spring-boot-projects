package com.example.DoProcess.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.DoProcess.DAO.EmployeeDAOJPA;
import com.example.DoProcess.Entity.Employee;
@Service
public class EmployeeServicesImpl implements EmployeeServices {
	/*
	 * private EmployeeDAO employeeDao;
	 * 
	 * @Autowired public EmployeeServicesImpl(EmployeeDAO employeeDao) {
	 * this.employeeDao = employeeDao; }
	 * 
	 * @Override
	 * 
	 * @Transactional public List<Employee> findAll() { return
	 * employeeDao.findAll(); }
	 * 
	 * @Override
	 * 
	 * @Transactional public Employee findById(int id) { return
	 * employeeDao.findById(id); }
	 * 
	 * @Override
	 * 
	 * @Transactional public List<Employee> findByName(String name) { return
	 * employeeDao.findByName(name); }
	 * 
	 * @Override
	 * 
	 * @Transactional public Employee save(Employee employee) { return
	 * employeeDao.save(employee); }
	 * 
	 * @Override
	 * 
	 * @Transactional public Employee delete(int id) { return
	 * employeeDao.delete(id); }
	 */
	
	private EmployeeDAOJPA employeeDaoJpa;
	@Autowired
	public EmployeeServicesImpl(EmployeeDAOJPA employeeDaoJpa) {
		this.employeeDaoJpa = employeeDaoJpa;
	}
	@Transactional
	@Override
	public List<Employee> findAll() {
		return employeeDaoJpa.findAll();
	}
	@Transactional
	@Override
	public Employee findById(int id) {
		return employeeDaoJpa.findById(id);
	}
	@Transactional
	@Override
	public List<Employee> findByName(String name) {
		return employeeDaoJpa.findByName(name);
	}
	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeDaoJpa.save(employee);
	}
	@Transactional
	@Override
	public Employee delete(int id) {
		return employeeDaoJpa.delete(id);
	}
}
