package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.database.service.StudentService;
import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;

public class CreateStudent {
	
	public boolean create(StudentService service, StudentInfoService infoService, FullStudentInfo fullInfo) {
		
		int nextID = service.getMaxID().getStudentID() + 1;
		
		Student student = new Student(nextID, fullInfo.getStudentName(), fullInfo.getStudentCode());
		StudentInfo studentInfo = 
				new StudentInfo(nextID, fullInfo.getAddress(), 
						fullInfo.getAvgScore(), fullInfo.getDateOfBirth());
		
		if (service.insert(student) > 0) {
			if (infoService.insert(studentInfo) > 0) {
				return true;
			} else {
				service.delete(student);
			}
		}
		return false;
	}
	
	public boolean notNull(StudentService service) {
		return service != null;
	}
}
