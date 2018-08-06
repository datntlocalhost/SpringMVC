package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentRecordsService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.StudentRecords;

public class UpdateStudent {

	public boolean updateStudent(StudentService studentService, StudentRecordsService recordService, StudentInfo info) {
		Student student = new Student(info.getStudentId(), info.getStudentName(), info.getStudentCode());
		StudentRecords record = new StudentRecords(info.getStudentId(), info.getAddress(), info.getAvgScore(), info.getDateOfBirth());

		studentService.update(student);
		recordService.update(record);

		return true;
	}

}
