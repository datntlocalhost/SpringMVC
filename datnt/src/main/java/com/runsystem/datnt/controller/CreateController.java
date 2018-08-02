package com.runsystem.datnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.business.CreateStudent;
import com.runsystem.datnt.database.service.FullStudentInfoService;
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
	
	@Autowired
	FullStudentInfoService fullInfoService;
	
	@PostMapping(value="/admin/create", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean onCreate(@ModelAttribute FullStudentInfo studentInfo, BindingResult result) {
	
		FullStudentValidator validator = new FullStudentValidator();
		validator.validate(studentInfo, result);
	
		if (result.hasErrors()) {
			System.out.println("have error");
			return false;
		} else {
			CreateStudent createStudent = new CreateStudent();
			if (createStudent.create(studentService, studentInfoService, studentInfo)) {
				return true;
			}
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private void init(Model model) {
		Student student = new Student();
		List<FullStudentInfo> students = fullInfoService.search(student);
		
		model.addAttribute("info", new FullStudentInfo());
		model.addAttribute("studentSearch", new Student());
		model.addAttribute("student", new Student());
		model.addAttribute("students", students );
	}*/
	
	/*
	 * Xử lý GET request 
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String onAccess(Model model) {
		init(model);
		return "admin";
	}*/
	/*
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public String onCreate(@ModelAttribute("info") FullStudentInfo studentInfo, @ModelAttribute("studentSearch") Student student, BindingResult result, Model model) {
		/*FullStudentValidator validator = new FullStudentValidator();
		validator.validate(studentInfo, result);
		
		if (result.hasErrors()) {
			System.out.println("have error");
			return "admin";
		} else {
			
			CreateStudent createStudent = new CreateStudent();
			if (createStudent.create(studentService, studentInfoService, studentInfo)) {
				model.addAttribute("fullstudentinfo", new FullStudentInfo());
				model.addAttribute("success", "Create student " + studentInfo.getStudentName() + " successful.");
				return "admin";
			} else {
				
			}
		}
		
		model.addAttribute("students", fullInfoService.search(student));
		return "admin";
	}*/
}
