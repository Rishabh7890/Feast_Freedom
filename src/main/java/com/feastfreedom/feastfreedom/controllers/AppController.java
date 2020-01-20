package com.feastfreedom.feastfreedom.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feastfreedom.feastfreedom.mailService;
import com.feastfreedom.feastfreedom.models.Kitchen;
import com.feastfreedom.feastfreedom.models.MenuItem;
import com.feastfreedom.feastfreedom.models.User;
import com.feastfreedom.feastfreedom.repositories.KitchenRepository;
import com.feastfreedom.feastfreedom.repositories.UserRepository;
import com.feastfreedom.feastfreedom.repositories.MenuItemReposiotry;

@Controller
public class AppController {

	@Autowired
	private KitchenRepository kr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private MenuItemReposiotry mir;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "_1index.html";
	}
	
	@RequestMapping("/Feast_Freedom")
	public String viewHomePagefeast(Model model) {
		return "_1index.html";
	}
	
	@RequestMapping("/kitchenlogin")
	public String viewKitchenLogin(Model model) {
		return "_2kitchenLogin.html";
	}

	@RequestMapping("/userlogin")
	public String viewUserLogin(Model model) {
		return "_2userLogin.html";
	}

	@RequestMapping("/kitchensignup")
	public String viewKitchenSignUp(Model model) {
		return "_2kitchenSignUp.html";
	}
	
	@RequestMapping("/Feast_Freedom/kitchensignup")
	public String viewKitchenSignUpfeast(Model model) {
		return "_2kitchenSignUp.html";
	}

	@RequestMapping("/usersignup")
	public String viewUserSignUp(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "_2userSignUpDemo.html";
	}
	
	
	@RequestMapping(value="/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) throws Exception {
		ur.save(user);
		mailService.userCreated(user.getUserEmail());
		return "redirect:/useradded";
		
	}
	
	@RequestMapping("/kitchenindex")
	public String viewKitchenIndex(Model model) {
		List<Kitchen> listKitchens = kr.findAll();
		model.addAttribute("listKitchens", listKitchens);
		return "_3kitchenIndex.html";
	}
	
	@RequestMapping("/Feast_Freedom/kitchenindex")
	public String viewKitchenIndexfeast(Model model) {
		List<Kitchen> listKitchens = kr.findAll();
		model.addAttribute("listKitchens", listKitchens);
		return "_3kitchenIndex.html";
	}

	@RequestMapping("/userindex")
	public String viewUserIndex(Model model) {
		List<Kitchen> listKitchens = kr.findAll();
		model.addAttribute("listKitchens", listKitchens);
		return "_3userIndex.html";
	}
	
	@RequestMapping("/Feast_Freedom/userindex")
	public String viewUserIndexfeast(Model model) {
		List<Kitchen> listKitchens = kr.findAll();
		model.addAttribute("listKitchens", listKitchens);
		return "_3userIndex.html";
	}

	/*
	@RequestMapping("/{kitchenName}/addmenuitem")
	public ModelAndView viewAddMenuItemPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4addMenuItem");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		mav.addObject("kitchen", kitchen);

		return mav;
	}
	*/
	
	
	@RequestMapping("{kitchenName}/addmenuitem")
	public String viewAddMenuItem(Model model) {
		MenuItem menu = new MenuItem();
		model.addAttribute("menu", menu);
		return "_4addMenuItemDemo.html";
	}
	
	
	@RequestMapping(value="/savemenuitem", method = RequestMethod.POST)
	public String saveMenuItem(@ModelAttribute("menu") MenuItem menu) {
		mir.save(menu);
		return "redirect:/kitchenindex";
		
	}
	
	/*
	@RequestMapping("/{kitchenName}/placeorder")
	public ModelAndView viewUserPlaceOrderPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4userPlaceOrder");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		//mav.addObject("kitchen", kitchen);
		List<MenuItem>listMenuItems = kitchen.getListMenuItems();
		mav.addObject("listMenuItems",listMenuItems);

		return mav;
	}
	*/
	
	@RequestMapping("/{kitchenName}/placeorder")
	public String viewUserPlaceOrderPage(Model model) {
		List<MenuItem> listMenuItems = mir.findAll();
		model.addAttribute("listMenuItems", listMenuItems);
		return "_4userPlaceOrder.html";
		
	}
	
	@RequestMapping("/Feast_Freedom/{kitchenName}/placeorder")
	public String viewUserPlaceOrderPagefeast(Model model) {
		List<MenuItem> listMenuItems = mir.findAll();
		model.addAttribute("listMenuItems", listMenuItems);
		return "_4userPlaceOrder.html";
		
	}
	
	

	@RequestMapping("/kitchenadded")
	public String viewAddKitchenSuccessPage(Model model) {
		return "_5kitchenAddSuccess.html";
	}

	/*
	 	
	@RequestMapping("/deletecustomer/{kitchen.id}")
	public String deleteCustomer(@PathVariable(name="customerid") Integer customerid) {
		service2.delete(customerid);
		return "redirect:/customer";
	}
	
	 */
	
	@RequestMapping("/useradded")
	public String viewAddUserSuccessPage(Model model) {
		return "_4UserAddSuccess.html";
	}

	/*
	@RequestMapping("/orderconfirmation")
	public ModelAndView viewOrderConfirmedPage(@PathVariable(name = "UserEmail") String UserEmail,@PathVariable(name="KitchenContactEmail")String KitchenContactEmail) throws Exception {
		ModelAndView conf = new ModelAndView("_5userOrderConfirmation");
		Kitchen kitchen = kr.findByKitchenContactEmail(KitchenContactEmail) ;
		User user = ur.findByUserEmail(UserEmail) ;
		mailService.confMail("mostafabeais215@gmai.com", KitchenContactEmail);

		return conf;
	}
	*/
	
	@RequestMapping("/orderconfirmation")
	public String viewOrderConfirmedPage(Model model) {
		return "_5userOrderConfirmation.html";
	}
	
	@RequestMapping("/Feast_Freedom/orderconfirmation")
	public String viewOrderConfirmedPagefeast(Model model) {
		return "_5userOrderConfirmation.html";
	}
	
	
	@RequestMapping("/vieworders")
	public String veiwViewOrders(Model model) {
		return "_4veiwOrders.html";
	}
}
