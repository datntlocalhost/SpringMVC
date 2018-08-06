package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.runsystem.datnt.business.SearchStudent;
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.validation.StudentValidator;

@Controller
public class SearchController {
	
	@Autowired
	StudentInfoService infoService;
	
	@RequestMapping(value = "/admin/search", method = RequestMethod.GET)
	public String onSearch(@ModelAttribute("student") Student student, @RequestParam(value = "page", required = true) Integer page, 
							BindingResult bindingResult, HttpServletRequest request, Model model) {
		HttpSession      session   = request.getSession();
		StudentValidator validator = new StudentValidator();
		SearchStudent    search    = new SearchStudent();
		validator.validate(student, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin";
		}
		
		PagenationResult pageResult = search.search(page, student, infoService);
		
		//Set session 
		session.setAttribute("student", student);
		session.setAttribute("pagenation", pageResult.getPagenation());
		
		//Set model
		model.addAttribute("student", student);
		model.addAttribute("pageResult", pageResult.getStudents());
		
		return "admin";
	}
}
