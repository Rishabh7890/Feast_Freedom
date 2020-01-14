package com.feastfreedom.feastfreedom.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feastfreedom.feastfreedom.models.MenuItem;
import com.feastfreedom.feastfreedom.repositories.MenuItemReposiotry;

@RestController
@RequestMapping("/items")
public class MenuItemController {
	
	@Autowired
	MenuItemReposiotry menu;
	
	@PostMapping //Create a new menu item
	public MenuItem createItem(@RequestBody MenuItem item) {
		menu.save(item);
		return item;
	}
	
	@GetMapping
	public List<MenuItem> getAllItems() {
		return menu.findAll();
	}
	
	
	@GetMapping("/{itemName}")   //Finding item by name 
	public MenuItem getItem(@PathVariable String itemName) {
		return menu.findByItemName(itemName);
		
	}
	
	
	@PutMapping("/{itemId}") //Update Item by ID
	public MenuItem updateItem(@RequestBody MenuItem item, @PathVariable int itemId) {
		item.setItemId(itemId);
		menu.save(item);
		return item;
		
	}
	
	@DeleteMapping("/{itemId}")
	public String deleteItem(@PathVariable int itemId) {
		menu.deleteById(itemId);
		return "Successful Deletion of Item";
	}
	
		
	
	

}
