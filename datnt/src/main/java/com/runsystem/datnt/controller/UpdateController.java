/**
 * UpdateCOntroller class
 * 
 * Controller xử lý các request liên quan đến cập nhật thông tin sinh viên.
 */
package com.runsystem.datnt.controller;

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
	 * Xử lý gửi thông tin của sinh viên cho client 
	 * 
	 * @param studentId     mã sinh viên lấy từ GET request 
	 * 
	 * @return studentInfo  thông tin sinh viên lấy từ db.
	 */
	@GetMapping(value = "/admin/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody StudentInfo getInfo(@PathVariable("id") int studentId) {
		StudentInfo studentInfo = infoService.selectById(String.valueOf(studentId));
		return studentInfo;
	}
	
	/*
	 * Xử lý cập nhật thông tin sinh viên, thông tin sinh viên mới được lấy từ POST request,
	 * gửi trả lại thông tin sinh viên sau khi cập nhật cho client.
	 * 
	 * @param studentInfo   thông tin sinh viên.
	 * @param bindingResult 
	 * 
	 * @return studeninfo  
	 */
	@PostMapping(value = "/admin/update")
	public @ResponseBody StudentInfo onUpdate(@ModelAttribute StudentInfo studentInfo, BindingResult bindingResult) {
		UpdateStudent update = new UpdateStudent();
		StudentInfoValidator validator = new StudentInfoValidator();
		validator.validate(studentInfo, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return null;
		}
		
		if (update.updateStudent(studentService, recordService, studentInfo)) {
			return studentInfo;
		}
		
		return null;
	}
}
