/**
 * UpdateController 
 * 
 * Nhận và xử lý các request POST GET từ client liên quan đến cập nhật
 * thông tin sinh viên. 
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
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.StudentRecords;
import com.runsystem.datnt.validation.StudentInfoValidator;

@Controller
public class UpdateController {
	
	@Autowired
	StudentService        studentService;
	
	@Autowired
	StudentRecordsService recordService;
	
	@Autowired
	StudentInfoService    infoService;
	
	/*
	 * Nhận GET request chứa thông điệp là mã id của sinh viên, tìm kiếm trong db và trả 
	 * kết quả cho client là object StudentInfo 
	 * 
	 * @param  studentId
	 *  
	 * @return studentInfo 
	 */
	@GetMapping(value="/admin/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody StudentInfo getInfoUpdate(@PathVariable("id") String studentId) {
		//Nếu input không hợp lệ thì return null
		if (!studentId.matches("^[0-9]*$")) {
			return null;
		}
		
		StudentInfo studentInfo = infoService.selectById(studentId);
		return studentInfo;
	}
	
	
	/*
	 * Nhận POST request chứa thông điệp thông tin sinh viên, sau đó câp nhật thông tin
	 * mới vào db.
	 * 
	 * @param studentInfo 
	 * @param result
	 * 
	 * @return boolean true nếu update thành công, false nếu không thành công 
	 * */
	@PostMapping(value="/admin/update", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean onUpdate(@ModelAttribute StudentInfo studentInfo, BindingResult result) {
		
		//Kiểm tra valid của input nhận được 
		StudentInfoValidator validator = new StudentInfoValidator();
		validator.validate(studentInfo, result);
		
		//Nếu không hợp lệ return false
		if (result.hasErrors()) {
			return false;
		}
		
		//Khởi tạo đối tượng Student 
		Student student = 
				new Student(studentInfo.getStudentId(), studentInfo.getStudentName(), studentInfo.getStudentCode());
		
		//Khởi tạo đối tượng StudentRecords
		StudentRecords records = 
				new StudentRecords(studentInfo.getStudentId(), studentInfo.getAddress(), studentInfo.getAvgScore(), 
						studentInfo.getDateOfBirth());
		
		//Nếu update thành công return true 
		if (studentService.update(student) > 0 && recordService.update(records) > 0) {
			return true;
		}
		return false;
	}
}
