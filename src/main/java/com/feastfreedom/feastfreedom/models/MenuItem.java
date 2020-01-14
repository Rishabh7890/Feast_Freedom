package com.feastfreedom.feastfreedom.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menuItem")
public class MenuItem {
	
	@Id
	private int itemId;
	
	private int itemName;
	private String mealType;
	private int price;
	private String parentKitchen;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getParentKitchen() {
		return parentKitchen;
	}
	public void setParentKitchen(String parentKitchen) {
		this.parentKitchen = parentKitchen;
	}
	public int getItemName() {
		return itemName;
	}
	public void setItemName(int itemName) {
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
