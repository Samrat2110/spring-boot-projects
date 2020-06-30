package com.example.DoProcess.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.DoProcess.Entity.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee>query=session.createQuery("from Employee",Employee.class);
		List<Employee>list=query.getResultList();
		return list;
	}

	@Override
	public Employee findById(int id) {
		Session session =entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> findByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee>query=session.createQuery("from Employee where Name = :employeeName",Employee.class);
		query.setParameter("employeeName", name);
		List<Employee>list=query.getResultList();
		return list;
	}

	@Override
	public Employee save(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;
	}

	@Override
	public Employee delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		Query query=session.createQuery("delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		return employee;
	}

}
