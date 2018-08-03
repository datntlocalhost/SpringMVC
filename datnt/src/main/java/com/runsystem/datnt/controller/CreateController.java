/**
 * CreateController class
 * 
 * Controller chịu trách nhiệm xử lý các request liên quan đến tạo mới sinh viên.
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
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.validation.StudentInfoValidator;

@Controller
public class CreateController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRecordsService studentRecordsService;

	@Autowired
	StudentInfoService fullInfoService;

	/*
	 * Nhận POST request từ form create new student, insert vào database và gửi 
	 * kết quả tạo mới cho client
	 * 
	 * @param studentInfo 
	 * @param result
	 * 
	 * @return boolean true nếu tạo mới thành công, false nếu thất bại.
	 */
	@PostMapping(value="/admin/create", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean onCreate(@ModelAttribute StudentInfo studentInfo, BindingResult result) {
		//Kiểm tra validation cho studentinfo 
		StudentInfoValidator validator = new StudentInfoValidator();
		validator.validate(studentInfo, result);

		if (result.hasErrors()) {
			return false;
		} else {
			CreateStudent createStudent = new CreateStudent();
			if (createStudent.create(studentService, studentRecordsService, studentInfo)) {
				return true;
			}
		}
		return false;
	}
}
