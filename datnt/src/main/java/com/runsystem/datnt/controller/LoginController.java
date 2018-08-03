/**
 * Class LoginController
 * 
 * Controller chịu trách nhiệm xử lý các incoming login request
 */
package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.database.service.UserService;
import com.runsystem.datnt.dto.User;
import com.runsystem.datnt.util.HashSHA1;
import com.runsystem.datnt.validation.UserValidator;

@Controller
public class LoginController {

	/*
	 * Khai báo user service để kết nối và lấy dữ liệu từ db
	 */
	@Autowired
	UserService userService;

	/*
	 * Nhận post request, cast thông tin user từ form sang object User,
	 * check valid cho username và password sau đó kiểm tra user có tồn
	 * tại trong db, nếu có thì chuyển hướng user sang admin page, set 
	 * session , ngược lại return chuỗi null.
	 * 
	 * @param user 
	 * @param binhdingResult
	 * @param request 
	 * 
	 * @return String 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String onLogin(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		HttpSession session = request.getSession();

		String username = user.getUsername();

		//password được hash sha1 trước khi truy vấn đến db
		String password = HashSHA1.hashSHA1(user.getPassword());

		//Khởi tạo Uservalidtor để kiểm tra input có hợp lệ 
		UserValidator validator = new UserValidator();

		validator.validate(user, bindingResult);

		//Nếu input username password không hợp lệ 
		if (bindingResult.hasErrors()) {
			return null;
		}

		User userCheck = userService.selectOne(new User(username, password));
		//Nếu user có trong db thì return đến trang admin
		if (userCheck != null) {
			//set session 
			session.setAttribute("user", new User(username, password));
			return "/datnt/views/admin.html";
		}

		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String onGet(@RequestParam("page") String page) {
		System.out.println(page);
		return null;
	}
}
