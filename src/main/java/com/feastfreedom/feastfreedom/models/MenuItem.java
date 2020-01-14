package com.feastfreedom.feastfreedom.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("MenuItem")
public class MenuItem {
	
	@Id
	private String id;
	
	private String itemName;
	private String mealType;
	private int price;
	private String parentKitchen;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentKitchen() {
		return parentKitchen;
	}
	public void setParentKitchen(String parentKitchen) {
		this.parentKitchen = parentKitchen;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
