/**
 * UpdateCOntroller class
 * 
 * Controller processing requests related to update student info.
 */
package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.business.UpdateStudent;
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.validation.StudentInfoValidator;

@Controller
public class UpdateController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRecordsService recordService;

	@Autowired
	StudentInfoService infoService;

	/*
	 * Send student's info to client.
	 * 
	 * @param studentId     student's id.
	 * 
	 * @return studentInfo  student's info.
	 */
	@GetMapping(value = "/admin/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody StudentInfo getInfo(@PathVariable("id") int studentId) {
		StudentInfo studentInfo = infoService.selectById(String.valueOf(studentId));
		return studentInfo;
	}

	/*
	 * Processing update student's info.
	 * 
	 * @param studentInfo   
	 * @param bindingResult 
	 * 
	 * @return studeninfo  
	 */
	@PostMapping(value = "/admin/update")
	public @ResponseBody StudentInfo onUpdate(@ModelAttribute StudentInfo studentInfo, BindingResult bindingResult, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UpdateStudent update = new UpdateStudent();
		StudentInfoValidator validator = new StudentInfoValidator();
		validator.validate(studentInfo, bindingResult);

		//check if users are not login, then return null
		if (session.getAttribute("user") == null) {
			return null;
		}
		
		//return null if input is invalid
		if (bindingResult.hasErrors()) {
			return null;
		}
		
		//if update success return student's info 
		if (update.updateStudent(studentService, recordService, studentInfo)) {
			return studentInfo;
		}

		return null;
	}
}
