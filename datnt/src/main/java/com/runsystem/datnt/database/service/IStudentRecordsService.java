package com.runsystem.datnt.database.service;

import java.util.List;
import com.runsystem.datnt.dto.StudentRecords;

public interface IStudentRecordsService {
	
	public int insert(StudentRecords studentInfo);
	
	public int update(StudentRecords studentInfo);
	
	public int delete(int studentInfo);
	
	public StudentRecords selectOne(StudentRecords studentInfo);
	
	public List<StudentRecords> selectAll();
}
