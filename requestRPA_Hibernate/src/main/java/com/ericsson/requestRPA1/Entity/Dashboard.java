package com.ericsson.requestRPA1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dashboard")
public class Dashboard {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="name")
	String name;
	@Column(name="customer")
	String customer;
	@Column(name="rparequired")
	String rparequired;
	
	public Dashboard() {
		
	}

	public Dashboard(String name, String customer, String rparequired) {
		super();
		this.name = name;
		this.customer = customer;
		this.rparequired = rparequired;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRparequired() {
		return rparequired;
	}

	public void setRparequired(String rparequired) {
		this.rparequired = rparequired;
	}

	@Override
	public String toString() {
		return "Dashboard [id=" + id + ", name=" + name + ", customer=" + customer + ", rparequired=" + rparequired
				+ "]";
	}
	
	
}
