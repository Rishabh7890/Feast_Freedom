package com.feastfreedom.feastfreedom.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Kitchen")
public class Kitchen {

	@Id
	private String id;

	@Indexed(name = "kitchenName")
	private String kitchenName;
	private String kitchenContactEmail;
	private String kitchenContactPassword;
	private String kitchenWorkingDays;
	private String kitchenWorkingHours;
	private String kitchenImg;
	private List<MenuItem> listMenuItems;

	public String getKitchenImg() {
		return kitchenImg;
	}

	public void setKitchenImg(String kitchenImg) {
		this.kitchenImg = kitchenImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKitchenName() {
		return kitchenName;
	}

	public void setKitchenName(String kitchenName) {
		this.kitchenName = kitchenName;
	}

	public String getKitchenContactEmail() {
		return kitchenContactEmail;
	}

	public void setKitchenContactEmail(String kitchenContactEmail) {
		this.kitchenContactEmail = kitchenContactEmail;
	}

	public String getKitchenContactPassword() {
		return kitchenContactPassword;
	}

	public void setKitchenContactPassword(String kitchenContactPassword) {
		this.kitchenContactPassword = kitchenContactPassword;
	}

	public String getKitchenWorkingDays() {
		return kitchenWorkingDays;
	}

	public void setKitchenWorkingDays(String kitchenWorkingDays) {
		this.kitchenWorkingDays = kitchenWorkingDays;
	}

	public String getKitchenWorkingHours() {
		return kitchenWorkingHours;
	}

	public void setKitchenWorkingHours(String kitchenWorkingHours) {
		this.kitchenWorkingHours = kitchenWorkingHours;
	}

	public List<MenuItem> getListMenuItems() {
		return listMenuItems;
	}

	public void setMenu(List<MenuItem> listMenuItems) {
		this.listMenuItems = listMenuItems;
	}

	public String k=getKitchenContactEmail();
}
