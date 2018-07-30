/*
 * Class LoginController
 * 
 * Controller chịu trách nhiệm xử lý các incoming request
 */
package com.runsystem.datnt.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.runsystem.datnt.database.service.UserService;
import com.runsystem.datnt.dto.User;
import com.runsystem.datnt.util.HashSHA1;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String onAccess(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String onLogin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		String username = user.getUsername();
		String password = HashSHA1.hashSHA1(user.getPassword());
		
		User userCheck = userService.selectOne(new User(username, password));
		
		if (userCheck != null) {
			return "home";
		}
		return "login";
	}
}
