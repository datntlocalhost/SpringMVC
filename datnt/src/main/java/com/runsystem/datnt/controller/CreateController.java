package com.runsystem.datnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.runsystem.datnt.business.CreateStudent;
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.validation.FullStudentValidator;

@Controller
public class CreateController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentInfoService studentInfoService;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String onAccess(Model model) {
		
		model.addAttribute("fullstudentinfo", new FullStudentInfo());
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String onCreate(@ModelAttribute("fullstudentinfo") FullStudentInfo studentInfo , 
			BindingResult result, Model model) {
		
		FullStudentValidator validator = new FullStudentValidator();
		validator.validate(studentInfo, result);
		
		if (result.hasErrors()) {
			return "add";
		} else {
			
			CreateStudent createStudent = new CreateStudent();
			if (createStudent.create(studentService, studentInfoService, studentInfo)) {
				model.addAttribute("fullstudentinfo", new FullStudentInfo());
				model.addAttribute("success", "Create student " + studentInfo.getStudentName() + " successful.");
				return "add";
			} else {
				
			}
		}
		return "add";
	}
}
