package com.feastfreedom.feastfreedom.controllers;

import com.feastfreedom.feastfreedom.models.User;
import com.feastfreedom.feastfreedom.services.CustomUserDetailsService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private CustomUserDetailsService userService;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("_2userLogin");
		return mav;
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("_2userSignUp");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findByUserEmail(user.getUserEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("_2userSignUp");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("_2userLogin");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/users/userindex", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView("_3userIndex");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUserEmail(auth.getName());
		modelAndView.addObject("UserEmail", user);
		modelAndView.addObject("UserFname", "Welcome " + user.getUserFname());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView home() {
	    ModelAndView modelAndView = new ModelAndView("_1index");
//	    modelAndView.setViewName("home");
	    return modelAndView;
	}


}
