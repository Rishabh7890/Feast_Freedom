package com.feastfreedom.feastfreedom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feastfreedom.feastfreedom.models.Kitchen;

public interface KitchenRepository extends MongoRepository<Kitchen, String> {
	
	public Kitchen findByKitchenName(String kitchenName);

}
