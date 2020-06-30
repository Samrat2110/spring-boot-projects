package com.example.DoProcess.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.DoProcess.Entity.Employee;
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAOJPA {
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query=entityManager.createQuery("from Employee");
		List<Employee>list=query.getResultList();
		return list;
	}

	@Override
	public Employee findById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> findByName(String name) {
		Query query = entityManager.createQuery("from Employee where Name =:employeeName");
		query.setParameter("employeeName", name);
		List<Employee>list=query.getResultList();
		return list;
	}

	@Override
	public Employee save(Employee employee) {
		Employee emp=entityManager.merge(employee);
		employee.setId(emp.getId());
		return emp;
	}

	@Override
	public Employee delete(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		Query query=entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		return employee;
	}

}
