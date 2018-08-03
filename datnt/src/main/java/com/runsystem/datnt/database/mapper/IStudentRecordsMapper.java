package com.runsystem.datnt.database.mapper;

import java.util.List;
import com.runsystem.datnt.dto.StudentRecords;

public interface IStudentRecordsMapper {
	
	public int insert(StudentRecords studentInfo);
	
	public int update(StudentRecords studentInfo);
	
	public int delete(int studentInfo);
	
	public StudentRecords selectOne(StudentRecords studentInfo);
	
	public List<StudentRecords> selectAll();

}
