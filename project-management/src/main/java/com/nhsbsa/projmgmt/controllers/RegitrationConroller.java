package com.nhsbsa.projmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nhsbsa.projmgmt.entity.User;
import com.nhsbsa.projmgmt.service.UserService;

@Controller
public class RegitrationConroller {

	/*
	 * @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String register(Model model) {
		User userAcc = new User();
		model.addAttribute("userAccount", userAcc);
		return "security/register";
	}

	@PostMapping("register/save")
	public String saveUser(Model model, User userAccount) {
		//userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
		userService.save(userAccount);
		return "main/home";
	}
}
