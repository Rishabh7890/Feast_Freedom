package com.feastfreedom.feastfreedom.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Admin")
public class Admin {

	private String id;
	private String AdminFname;
	private String AdminLname;
	private String AdminEmail;
	private String AdminPassword;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdminFname() {
		return AdminFname;
	}
	public void setAdminFname(String adminFname) {
		AdminFname = adminFname;
	}
	public String getAdminLname() {
		return AdminLname;
	}
	public void setAdminLname(String adminLname) {
		AdminLname = adminLname;
	}
	public String getAdminEmail() {
		return AdminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	



}