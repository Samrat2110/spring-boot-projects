package com.ericsson.requestRPA1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.requestRPA1.Dao.DashboardDao;
import com.ericsson.requestRPA1.Entity.Dashboard;
@Service
public class DashboardServiceImpl implements DashboardService {
	DashboardDao dao;
	
	@Autowired
	public DashboardServiceImpl(DashboardDao theDao) {
		dao=theDao;
	}
	@Override
	@Transactional
	public List<Dashboard> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Dashboard findById(int id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Dashboard dashboard) {
		dao.save(dashboard);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		dao.deleteById(id);

	}
	@Override
	@Transactional
	public List<Dashboard> findByName(String name) {
		return dao.findByName(name);
	}
	
	

}
