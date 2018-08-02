package com.runsystem.datnt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.database.service.FullStudentInfoService;
import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;

@Controller
public class SearchController {
	
	@Autowired
	FullStudentInfoService searchResult;

	@PostMapping(value="/admin/search", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody PagenationResult getResult(@ModelAttribute Student student, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("search", student);
		
		Pagenation pageSearch   = new Pagenation();
		PagenationResult result = new PagenationResult();
		
		pageSearch.setStudentCode(student.getStudentCode().length() > 0 ? student.getStudentCode(): null);
		pageSearch.setStudentName(student.getStudentName().length() > 0 ? student.getStudentName(): null);
		
		List<FullStudentInfo> students = searchResult.selectLimit(pageSearch);
		//lay so dong ket qua tim kiem
		int numRow = searchResult.count(student);
		
		result.setNumRaw(numRow);
		result.setStudents(students);
		/*
		 * số page sẽ là numRaw/10 nếu phần dư của numRow/10 < 0, 
		 * sẽ là numRow/10 + 1 nếu phần dư numRow/10 > 0
		 */
		int maxPage = numRow%10 > 0 ? numRow/10 + 1 : numRow/10;
		result.setMaxPage(maxPage);
		result.setStartPage(1);
		result.setEndPage(maxPage < 10 ? maxPage : 10);
		
		return result;
	}
	
	@GetMapping(value = "/admin")
	public @ResponseBody PagenationResult changePage(@RequestParam("page") int page, HttpServletRequest request) {
		Pagenation pagenation = new Pagenation();
		PagenationResult pagenationResult = new PagenationResult();
		HttpSession session = request.getSession();
		
		Student student = (Student) session.getAttribute("search");
		
		if (student != null) {
			pagenation.setNumHope(10);
			pagenation.setStart(page*10 + 1);
			pagenation.setStudentCode(student.getStudentCode());
			pagenation.setStudentName(student.getStudentName());
			List<FullStudentInfo> students = searchResult.selectLimit(pagenation);
		}
		
		return pagenationResult;
	}
}
