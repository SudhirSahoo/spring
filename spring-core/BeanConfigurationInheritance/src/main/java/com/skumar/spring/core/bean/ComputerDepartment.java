package com.skumar.spring.core.bean;

public class ComputerDepartment {

	private String totalStrength;
	private String branchStrength;
	private String principal;
	private String name;
	private String id;
	private String location;
	
	public String getTotalStrength() {
		return totalStrength;
	}
	public void setTotalStrength(String totalStrength) {
		this.totalStrength = totalStrength;
	}
	public String getBranchStrength() {
		return branchStrength;
	}
	public void setBranchStrength(String branchStrength) {
		this.branchStrength = branchStrength;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	@Override
	public String toString() {
		return "ID [id=" + id + ", Branch Name=" + name + ", Total Strength=" + totalStrength + ", Branch Strength=" + branchStrength + ", Principal=" + principal + ", Location=" + location + "]";
	}	

}
