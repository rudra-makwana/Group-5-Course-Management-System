package com.example.group5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.group5.entities.User;
import com.example.group5.services.UserService;

/**
 * This is controller class for mapping requests with responses
 * @author Japnoor Kaur
 *
 */
@Controller
public class RegisterController {


	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerAction(User user, Model model, UserService userService) {

		if(userService.bannerIdExists(user.getBannerId())) {
			model.addAttribute("bannerIdAlreadyExists", true);
			return "register";
		}
		if(userService.userExists(user.getEmailID())) {
			model.addAttribute("userAlreadyExists", true);
			return "register";

		}
		if(userService.validateBannerId(user.getBannerId())) {
			model.addAttribute("bannerIdError", true);
			return "register";

		}
		if(userService.validateFirstName(user.getFirstName())) {
			model.addAttribute("firstNameError", true);
			return "register";

		}
		if(userService.validateLastName(user.getLastName())) {
			model.addAttribute("lastNameError", true);
			return "register";

		}

		if(userService.validateEmail(user.getEmailID())) {
			model.addAttribute("emailError", true);
			return "register";

		}
		if(userService.validatePassword(user.getPassword())) {
			model.addAttribute("passwordError", true);
			return "register";

		}

		else {
			userService.addUser(user);
			return "success";
		}
	}
}