package com.ericsson.requestRPA1.Rest;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ericsson.requestRPA1.Entity.Dashboard;
import com.ericsson.requestRPA1.Service.DashboardService;

@RestController
@RequestMapping("/api")
public class DashboardRestController {

	DashboardService service;
	
	@Autowired
	public DashboardRestController(DashboardService theService) {
		service=theService;
	}
	@GetMapping("/dashboard")
	public List<Dashboard> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/dashboard/id/{id}")
	public Dashboard findById(@PathVariable int id) {
		Dashboard dashboard=service.findById(id);
		if(dashboard==null) {
			throw new RuntimeException("Dashboard not found for ID-"+id);
		}
		return dashboard;
	}
	@GetMapping("/dashboard/name/{name}")
	public List<Dashboard> findByname(@PathVariable  String name) {
		List<Dashboard> list=service.findByName(name);
		if(list.isEmpty()) {
			throw new RuntimeException("Dashboard not found for name-"+name);
		}
		return list;
	}
	@PostMapping("/dashboard")
	public Dashboard save(@RequestBody Dashboard dashboard) {
		dashboard.setId(0);
		service.save(dashboard);
		return dashboard;
		
	}
	@DeleteMapping("/dashboard/deleteId{id}")
	public Dashboard deleteById(@PathVariable int id) {
		Dashboard dashboard=service.findById(id);
		if(dashboard == null) {
			throw new RuntimeException("Dashboard not found for ID-"+id);
		}
		service.deleteById(id);
		return dashboard;
		
	}
	@PutMapping("/dashboard/updateId")
		public Dashboard update(@RequestBody Dashboard dashboard) {
			service.save(dashboard);
			return dashboard;
		}
	}

