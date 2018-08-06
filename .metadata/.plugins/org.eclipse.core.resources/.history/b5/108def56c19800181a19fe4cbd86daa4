/**
 * AdminController class
 * 
 * Controller xử lý GET request khi client truy cập vào admin page
 */

package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;

@Controller
public class AdminController {
	
	/*
	 * Nhận GET request khi client truy cập vào page admin, chuyển hướng đến page login 
	 * nếu client chưa đăng nhập, chuyển đến trang page admin nếu client đã đăng nhập.
	 * 
	 * @param request 
	 * 
	 * @return String 
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String onAdmin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:login";
		} else {
			PagenationResult result = new PagenationResult();
			model.addAttribute("pagenation", result.getPagenation());
			model.addAttribute("pageResult", result.getStudents());
			model.addAttribute("student", new Student());
			return "admin";
		}
	}
}
