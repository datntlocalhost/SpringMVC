/**
 * CreateController class
 * 
 * Controller xử lý các request liên quan đến tạo mới sinh viên
 */
package com.runsystem.datnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runsystem.datnt.business.CreateStudent;
import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.validation.StudentInfoValidator;

@Controller
public class CreateController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRecordsService recordService;

	/*
	 * Nhận POST request chứ thông tin sinh viên cần tạo mới, gọi phương thức tạo mới lưu vào db,
	 * gửi thông báo lại cho client.
	 * 
	 * @param info          Thông tin sinh viên 
	 * @param bindingResult 
	 * 
	 * @return boolean 
	 */
	@PostMapping(value = "/admin/create", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean onCreate(@ModelAttribute StudentInfo info, BindingResult bindingResult) {
		StudentInfoValidator validator = new StudentInfoValidator();
		CreateStudent        create    = new CreateStudent();
		
		//Check validator input 
		validator.validate(info, bindingResult);
		
		//Nếu input không hợp lệ return false
		if (bindingResult.hasErrors()) {
			return false;
		}
		
		//return true nếu tạo mới thành công, ngược lai false.
		return create.create(studentService, recordService, info);
	}
}
