package com.feastfreedom.feastfreedom.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feastfreedom.feastfreedom.models.Kitchen;
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

	@RequestMapping("/usersignup")
	public String viewUserSignUp(Model model) {
		return "_2userSignUp.html";
	}
	
	
	@RequestMapping(value="/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		ur.save(user);
		return "_3userIndex.html";
		
	}
	
	@RequestMapping("/kitchenindex")
	public String viewKitchenIndex(Model model) {
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

	@RequestMapping("/{kitchenName}/addmenuitem")
	public ModelAndView viewAddMenuItemPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4addMenuItem");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		mav.addObject("kitchen", kitchen);

		return mav;
	}

	@RequestMapping("/{kitchenName}/placeorder")
	public ModelAndView viewUserPlaceOrderPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4userPlaceOrder");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		mav.addObject("kitchen", kitchen);

		return mav;
	}

	@RequestMapping("/kitchenadded")
	public String viewAddKitchenSuccessPage(Model model) {
		return "_5kitchenAddSuccess.html";
	}

	@RequestMapping("/orderconfirmation")
	public String viewOrderConfirmedPage(Model model) {
		return "_5userOrderConfirmation.html";
	}

}
