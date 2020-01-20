package com.feastfreedom.feastfreedom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feastfreedom.feastfreedom.models.Kitchen;
import com.feastfreedom.feastfreedom.models.User;

public interface KitchenRepository extends MongoRepository<Kitchen, String> {
	
	public Kitchen findByKitchenName(String kitchenName);
	public Kitchen findByKitchenContactEmail(String kitchenContactEmail);
	public Kitchen findByKitchenContactPassword(String kitchenContactPassword);

}
