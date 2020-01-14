package com.feastfreedom.feastfreedom.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User {

	@Id
	private String id;
	
	private String UserFname;
	private String UserLname;
	private String UserEmail;
	private String UserPassword;
	private List<MenuItem> orders;
	private List<MenuItem> cart;
	
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


	public List<MenuItem> getOrders() {
		return orders;
	}


	public void setOrders(List<MenuItem> orders) {
		this.orders = orders;
	}


	public List<MenuItem> getCart() {
		return cart;
	}


	public void setCart(List<MenuItem> cart) {
		this.cart = cart;
	}
	
	
	
	
}
