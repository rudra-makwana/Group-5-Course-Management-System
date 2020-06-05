package com.example.group5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.group5.model.User;
import com.example.group5.services.LoginService;
import com.example.group5.services.UserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is controller class for mapping requests with responses
 * @author Japnoor Kaur
 * updated by Chetanpreet Singh for login
 *
 */
@RestController
@RequestMapping("/")
public class RegisterController {

	//Login code by Chetanpreet Singh
	@GetMapping("/login")                               //called when/login is called
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());    //User going to form
		return "login";
	}
	
	


	@RequestMapping(value = "/loginaction",method = RequestMethod.POST)
	public ModelAndView loginAction(@RequestParam(name = "user") User user)       //User object(From the form submission) and Model object
	{
		LoginService loginService = new LoginService();
		ModelAndView modelAndView = new ModelAndView();
		String response = loginService.findUser(user);
		if(response == "admin"){
			modelAndView.setViewName("AdminDashboard");
			return modelAndView;
		}
		else {
			modelAndView.addObject("bannerID",user.getBannerId());
			modelAndView.setViewName("userdashboard");
			return modelAndView;
		}
	}


	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerAction(User user, Model model, UserService userService) {

		if(userService.bannerIdExists(user.getBannerId())) 
		{
			model.addAttribute("bannerIdAlreadyExists", true);
			return "register";
		}
		
		
		if(userService.userExists(user.getEmailID())) 
		{
			model.addAttribute("userAlreadyExists", true);
			return "register";

		}
		
		
		if(userService.validateBannerId(user.getBannerId())) 
		{
			model.addAttribute("bannerIdError", true);
			return "register";

		}
		
		
		if(userService.validateFirstName(user.getFirstName())) 
		{
			model.addAttribute("firstNameError", true);
			return "register";

		}
		
		
		if(userService.validateLastName(user.getLastName())) 
		{
			model.addAttribute("lastNameError", true);
			return "register";

		}

		if(userService.validateEmail(user.getEmailID())) 
		{
			model.addAttribute("emailError", true);
			return "register";

		}
		if(userService.validatePassword(user.getPassword())) 
		{
			model.addAttribute("passwordError", true);
			return "register";

		}

		else {
			userService.addUser(user);
			return "success";
		}
	}
}