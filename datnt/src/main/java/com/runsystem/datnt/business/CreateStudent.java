/**
 * CreaeStudent class
 */
package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentRecords;
import com.runsystem.datnt.util.GenerateStudentCode;

public class CreateStudent {
	
	
	/*
	 * Create new student
	 * 
	 * @param studentSerivce   
	 * @param recordService    
	 * @param fullInfo         
	 * 
	 * @return boolean 
	 * */
	public boolean create(StudentService studentService, StudentRecordsService recordService, StudentInfo fullInfo) {
		//Next student id, default is 1.
		int nextID = 1;
		
		//Get max id in database and assign to nextID.
		if (studentService.getMaxID() != null ) {
			nextID = studentService.getMaxID().getStudentID() + 1;
		}
		
		String studentCode = GenerateStudentCode.getCode(nextID);
		
		Student student = new Student(nextID, fullInfo.getStudentName(), studentCode);
		 
		StudentRecords studentRecords = new StudentRecords(nextID, fullInfo.getAddress(), fullInfo.getAvgScore(), 
				fullInfo.getDateOfBirth());
		
		//Check if create new success then return true
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
