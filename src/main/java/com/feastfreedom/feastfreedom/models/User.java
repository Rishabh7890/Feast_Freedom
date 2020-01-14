package com.feastfreedom.feastfreedom.models;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document("User")
public class User {

	@Id
	private String id;

	private String UserFname;
	private String UserLname;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String UserEmail;
	private String UserPassword;
	private List<MenuItem> orders;
	private List<MenuItem> cart;
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@DBRef
	private Set<Role> roles;

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
