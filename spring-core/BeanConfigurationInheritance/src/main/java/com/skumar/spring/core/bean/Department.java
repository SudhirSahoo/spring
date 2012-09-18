package com.skumar.spring.core.bean;

public class Department {
	private String location;
	private String principal;
	private String totalStrength;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	public String getTotalStrength() {
		return totalStrength;
	}
	public void setTotalStrength(String totalStrength) {
		this.totalStrength = totalStrength;
	}
	
	@Override
	public String toString() {
		return "ID [Location=" + location + ", Principal=" + principal + ", TotalStrength=" + totalStrength + "]";
	}	
}
