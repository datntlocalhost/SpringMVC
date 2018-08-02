/*
 * Class LoginController
 * 
 * Controller chịu trách nhiệm xử lý các incoming request
 */
package com.runsystem.datnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.database.service.UserService;
import com.runsystem.datnt.dto.User;
import com.runsystem.datnt.util.HashSHA1;
import com.runsystem.datnt.validation.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String onLogin(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		String username = user.getUsername();
		String password = HashSHA1.hashSHA1(user.getPassword());
		
		UserValidator validator = new UserValidator();
		
		validator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return null;
		}
		
		User userCheck = userService.selectOne(new User(username, password));
		if (userCheck != null) {
			return "/datnt/views/admin.html";
		}
		
		return null;
	}
}
