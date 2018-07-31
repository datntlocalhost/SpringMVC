package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.dto.StudentInfo;

public interface IStudentInfoService {
	
	public int insert(StudentInfo studentInfo);
	
	public int update(StudentInfo studentInfo);
	
	public int delete(StudentInfo studentInfo);
	
	public StudentInfo selectOne(StudentInfo studentInfo);
	
	public List<StudentInfo> selectAll();
}
