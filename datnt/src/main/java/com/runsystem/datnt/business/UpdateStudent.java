/**
 * UpdateStudent class
 * 
 * Chứa các phương thức update thông tin sinh viên.
 */

package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.StudentRecords;

public class UpdateStudent {

	/*
	 * Update thông tin sinh viên
	 * 
	 * @param studentService 
	 * @param recordService
	 * @param info
	 * 
	 * @return boolean true nếu update thành công, ngược lại false.
	 */
	public boolean updateStudent(StudentService studentService, StudentRecordsService recordService, StudentInfo info) {
		Student student = new Student(info.getStudentId(), info.getStudentName(), info.getStudentCode());
		StudentRecords record = new StudentRecords(info.getStudentId(), info.getAddress(), info.getAvgScore(), info.getDateOfBirth());

		if (studentService.update(student) > 0 && recordService.update(record) > 0) {
			return true;
		}

		return false;
	}

}
