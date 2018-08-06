/**
 * CreaeStudent class
 * 
 * Chứa các phương thức tạo mới sinh viên
 */
package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentRecords;

public class CreateStudent {
	
	
	/*
	 * Xử lý tạo mới sinh viên
	 * 
	 * @param studentSerivce  thao tác với database sinh viên 
	 * @param recordService   thao tác với database thông tin sinh viên 
	 * @param fullInfo        thông tin sinh viên được truyền vào 
	 * 
	 * @return boolean        true nếu tạo mới thành công, ngược lại false 
	 * */
	public boolean create(StudentService studentService, StudentRecordsService recordService, StudentInfo fullInfo) {
		//ID sinh viên tiếp theo 
		int nextID = 1;
		
		//Lấy số id cao nhất hiện tại + 1
		if (studentService.getMaxID() != null ) {
			nextID = studentService.getMaxID().getStudentID() + 1;
		}
		
		//Khởi tạo đối tượng sinh viên 
		Student student = new Student(nextID, fullInfo.getStudentName(), fullInfo.getStudentCode());
		
		//Khởi tạo đối tượng thông tin sinh viên 
		StudentRecords studentRecords = new StudentRecords(nextID, fullInfo.getAddress(), fullInfo.getAvgScore(), 
				fullInfo.getDateOfBirth());
		
		//Kiểm tra thêm mới có thành công return true
		if (studentService.insert(student) > 0) {
			if (recordService.insert(studentRecords) > 0) {
				return true;
			} else {
				studentService.delete(student.getStudentID());
			}
		}
		return false;
	}
}
