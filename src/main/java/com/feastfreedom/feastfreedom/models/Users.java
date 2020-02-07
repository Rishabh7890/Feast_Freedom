package com.feastfreedom.feastfreedom.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class Users {

	private String id;
	private String UserFname;
	private String UserLname;
	private String UserEmail;
	private String UserPassword;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserFname() {
		return UserFname;
	}
	public void setUserFname(String userFname) {
		UserFname = userFname;
	}
	public String getUserLname() {
		return UserLname;
	}
	public void setUserLname(String userLname) {
		UserLname = userLname;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	
	
}
