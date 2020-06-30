package com.ericsson.requestRPA1.Service;

import java.util.List;

import com.ericsson.requestRPA1.Entity.Dashboard;

public interface DashboardService {

	public List<Dashboard> findAll();
	
	public Dashboard findById(int id);
	
	public List<Dashboard> findByName(String name);
	
	public void save(Dashboard dashboard);
	
	public void deleteById(int id);
}
