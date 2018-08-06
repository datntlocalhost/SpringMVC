package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runsystem.datnt.business.SearchStudent;
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;

@Controller
public class DeleteController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRecordsService recordService;

	@Autowired
	StudentInfoService infoService;

	@GetMapping(value = "/admin/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody PagenationResult onDelete(@RequestParam(value="values[]") Integer[] values, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SearchStudent    search    = new SearchStudent();
		
		//Xoa danh sach sinh vien
		for (int id : values) {
			recordService.delete(id);
			studentService.delete(id);
		}
		
		Student    student    = (Student) session.getAttribute("student");
		Pagenation pagenation = (Pagenation) session.getAttribute("pagenation");
		
		if (student != null && pagenation != null) {
			PagenationResult pageResult = search.search(pagenation.getCurPage(), student, infoService);
			session.setAttribute("pagenation", pageResult.getPagenation());
			return pageResult;
		}

		return null;
	}
	
	@GetMapping(value = "/admin/delete/{id}")
	public @ResponseBody PagenationResult onDeleteOne(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SearchStudent    search    = new SearchStudent();
		
		recordService.delete(id);
		studentService.delete(id);
		
		Student    student    = (Student) session.getAttribute("student");
		Pagenation pagenation = (Pagenation) session.getAttribute("pagenation");
		
		if (student != null && pagenation != null) {
			PagenationResult pageResult = search.search(pagenation.getCurPage(), student, infoService);
			session.setAttribute("pagenation", pageResult.getPagenation());
			return pageResult;
		}

		return null;
	}
}
