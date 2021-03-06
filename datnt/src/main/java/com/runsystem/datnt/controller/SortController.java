package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;

@Controller
public class SortController {

	@PostMapping(value = "/admin/sort")
	public @ResponseBody PagenationResult onSearch(@RequestParam("on") String dependOn, @RequestParam("type") String type, 
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		PagenationResult pageResult = new PagenationResult();
		Pagenation pagenation = (Pagenation) session.getAttribute("pagenation");
		
		if (session.getAttribute("user") == null || pagenation == null) {
			return pageResult;
		}
		
		
		
		return pageResult;
	}

}
