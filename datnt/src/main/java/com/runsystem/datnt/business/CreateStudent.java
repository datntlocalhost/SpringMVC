package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentRecords;

public class CreateStudent {
	
	public boolean create(StudentService studentService, StudentRecordsService recordService, StudentInfo fullInfo) {
		int nextID = 1;
		
		if (studentService.getMaxID() != null ) {
			nextID = studentService.getMaxID().getStudentID() + 1;
		}
		
		Student student = new Student(nextID, fullInfo.getStudentName(), fullInfo.getStudentCode());
		StudentRecords studentRecords = new StudentRecords(nextID, fullInfo.getAddress(), fullInfo.getAvgScore(), 
				fullInfo.getDateOfBirth());
		
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
