/**
 * DeleteController class
 * 
 * Nhận và xử lý các GET, POST request từ client liên quan đến xóa sinh viên
 * theo từng sinh viên hoặc theo danh sách được chọn.
 */

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

@Controller
public class DeleteController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRecordsService recordService;

	@Autowired
	StudentInfoService searchResult;

	/*
	 * Xử lý xóa từng sinh viên một, GET request được client gửi đến mang thông tin mã sinh viên,
	 * trả kết quả cho render sau khi xử lý xóa sinh viên được hoàn tất.
	 * 
	 * @param studentId 
	 * @param request 
	 * 
	 * @return PagenationResult 
	 */
	@GetMapping(value = "/admin/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody PagenationResult onDelete(@PathVariable("id") int studentId, HttpServletRequest request) {

		//valid student id

		//Xoa sinh vien
		if (recordService.delete(studentId) < 0 || studentService.delete(studentId) < 0) {
			return null;
		}

		//Return cho client
		HttpSession session = request.getSession();
		Pagenation pagenation = (Pagenation) session.getAttribute("pageinfo");
		if (pagenation == null) {
			return null;
		}

		SearchStudent search    = new SearchStudent();
		PagenationResult result = search.search(pagenation, searchResult, pagenation.getCurPage());
		if (result != null) {
			pagenation.setCurPage(result.getIndexPage());
			pagenation.setStartPage(result.getStartPage());
			pagenation.setEndPage(result.getEndPage());
			session.setAttribute("pageinfo", pagenation);
		}

		return result;
	}

	/*
	 * Xứ lý xóa một danh sách sinh viên được gửi từ client thông qua GET request.
	 * thông tin danh sách các id cần xóa được lưu trong một mảng số nguyên, trả kết quả
	 * cho việc render sau khi xóa xong.
	 * 
	 * @param values  mảng chứa các student id phải xóa 
	 * 
	 * @return PagenationResult 
	 */
	@GetMapping(value = "/admin/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody PagenationResult onDeleteList(@RequestParam(value="values[]") Integer[] values, HttpServletRequest request) {
		
		//Xoa danh sach sinh vien
		for (int id : values) {
			recordService.delete(id);
			studentService.delete(id);
		}

		//Return cho client
		HttpSession session = request.getSession();
		Pagenation pagenation = (Pagenation) session.getAttribute("pageinfo");
		if (pagenation == null) {
			return null;
		}

		SearchStudent search    = new SearchStudent();
		PagenationResult result = search.search(pagenation, searchResult, pagenation.getCurPage());

		if (result != null) {
			pagenation.setCurPage(result.getIndexPage());
			pagenation.setStartPage(result.getStartPage());
			pagenation.setEndPage(result.getEndPage());
			session.setAttribute("pageinfo", pagenation);
		}

		return result;
	}
}
