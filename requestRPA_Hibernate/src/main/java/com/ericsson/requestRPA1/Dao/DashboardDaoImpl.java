package com.ericsson.requestRPA1.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.requestRPA1.Entity.Dashboard;
@Repository
public class DashboardDaoImpl implements DashboardDao {
	private EntityManager entityManager;
	@Autowired
	public DashboardDaoImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	@Override
	public List<Dashboard> findAll() {
		Session session=entityManager.unwrap(Session.class);
		Query<Dashboard>query=session.createQuery("from Dashboard",Dashboard.class);
		List<Dashboard> list=query.getResultList();
		return list;
	}
	@Override
	public Dashboard findById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Dashboard dashboard=session.get(Dashboard.class, id);
		return dashboard;
	}
	@Override
	public void save(Dashboard dashboard) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(dashboard);
		
	}
	@Override
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query=session.createQuery("delete from Dashboard where id=:dashboardId");
		query.setParameter("dashboardId", id);
		query.executeUpdate();
	}
	@Override
	public List<Dashboard> findByName(String name) {
		Session session=entityManager.unwrap(Session.class);
		Query<Dashboard>query=session.createQuery("from Dashboard where name=:ownerName",Dashboard.class);
		query.setParameter("ownerName", name);
		List<Dashboard> list=query.getResultList();
		return list;
	}

}
