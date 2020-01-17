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
		User user = new User();
		model.addAttribute("user", user);
		return "_2userSignUpDemo.html";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		ur.save(user);
		return "redirect:/userindex";

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

	@RequestMapping("/addmenuitem/{kitchenName}")
	public ModelAndView viewAddMenuItemPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4addMenuItem");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		mav.addObject("kitchen", kitchen);

		return mav;
	}

	@RequestMapping("/placeorder/{kitchenName}")
	public ModelAndView viewUserPlaceOrderPage(@PathVariable(name = "kitchenName") String kitchenName) {
		ModelAndView mav = new ModelAndView("_4userPlaceOrder");
		Kitchen kitchen = kr.findByKitchenName(kitchenName);
		mav.addObject("kitchen", kitchen);
		List<MenuItem> menu = kitchen.getListMenuItems();
		mav.addObject("listMenuItems", menu);

		return mav;
	}

	@RequestMapping("/kitchenadded")
	public String viewAddKitchenSuccessPage(Model model) {
		return "_5kitchenAddSuccess.html";
	}

	/*
	 * @RequestMapping("/kitchenadded") public ModelAndView
	 * sendRestaurantConfirmationEmail(@PathVariable(name = "KitchenContactEmail")
	 * String KitchenContactEmail) throws Exception {
	 * mailService.kitchenCreated(KitchenContactEmail);
	 * 
	 * return null; }
	 */
	@RequestMapping("/useradded")
	public String viewAddUserSuccessPage(Model model) {
		return "_4UserAddSuccess.html";
	}
	/*
	 * @RequestMapping("/useradded") public ModelAndView
	 * sendUserConfirmationEmail(@PathVariable(name = "UserEmail") String UserEmail)
	 * throws Exception { mailService.userCreated(UserEmail); return null; }
	 */

	@RequestMapping("/orderconfirmation")
	public ModelAndView viewOrderConfirmedPage(@PathVariable(name = "UserEmail") String UserEmail,
			@PathVariable(name = "KitchenContactEmail") String KitchenContactEmail) throws Exception {
		ModelAndView conf = new ModelAndView("_5userOrderConfirmation");
		Kitchen kitchen = kr.findByKitchenContactEmail(KitchenContactEmail);
		User user = ur.findByUserEmail(UserEmail);
		mailService.confMail("mostafabeais215@gmai.com", KitchenContactEmail);

		return conf;
	}

	@RequestMapping("/vieworders")
	public String veiwViewOrders(Model model) {
		return "_4veiwOrders.html";
	}
}
