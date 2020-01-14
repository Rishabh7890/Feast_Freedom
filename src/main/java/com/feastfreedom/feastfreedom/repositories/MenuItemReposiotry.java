package com.feastfreedom.feastfreedom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feastfreedom.feastfreedom.models.MenuItem;

public interface MenuItemReposiotry extends MongoRepository<MenuItem, String>{
	
	public MenuItem findByItemName(String itemName);
	//public MenuItem deleteByItemId(String itemId);

 
}
