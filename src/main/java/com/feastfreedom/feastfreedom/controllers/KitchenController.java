// package com.feastfreedom.feastfreedom.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.feastfreedom.feastfreedom.mailService;
// import com.feastfreedom.feastfreedom.models.Kitchen;
// import com.feastfreedom.feastfreedom.repositories.KitchenRepository;

// @RestController
// @RequestMapping("/kitchens")
// public class KitchenController extends Kitchen{

// 	@Autowired
// 	KitchenRepository kr;

// 	// Create a kitchen

// 	@PostMapping
// 	public Kitchen createKitchen(@RequestBody Kitchen kitchen) throws Exception {
// 		kr.save(kitchen);
// 		mailService.kitchenCreated(getKitchenContactEmail());
// 		return kitchen;
// 	}

// 	// Get All Kitchens

// 	@GetMapping
// 	public List<Kitchen> getAllKitchens() {
// 		return kr.findAll();
// 	}

// 	// Get Individual Kitchen

// 	@GetMapping("/{kitchenName}")
// 	public Kitchen getKitchen(@PathVariable String kitchenName) {
// 		return kr.findByKitchenName(kitchenName);
// 	}

// 	// Update A Kitchen

// 	@PutMapping("{kitchenId}")
// 	public Kitchen updateKitchen(@RequestBody Kitchen kitchen, @PathVariable String kitchenId) {
// 		kitchen.setId(kitchenId);
// 		kr.save(kitchen);
// 		return kitchen;
// 	}

// 	// Delete A Kitchen

// 	@DeleteMapping("{kitchenId}")
// 	public String deleteKitchen(@PathVariable String kitchenId) {
// 		kr.deleteById(kitchenId);
// 		return "Kitchen Deleted";
// 	}

// }
