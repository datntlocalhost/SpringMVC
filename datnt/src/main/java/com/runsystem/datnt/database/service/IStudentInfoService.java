package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.Student;

public interface IStudentInfoService {
	
	public StudentInfo       selectById(String id);
	public List<StudentInfo> selectLimit(Pagenation param);
	public List<StudentInfo> search(Student param);
	public List<StudentInfo> sortNameASC(Pagenation param);
	public int 					 count(Student param);
}
