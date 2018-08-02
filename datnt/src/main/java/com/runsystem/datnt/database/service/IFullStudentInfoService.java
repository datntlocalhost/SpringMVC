package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.Student;

public interface IFullStudentInfoService {
	
	public List<FullStudentInfo> selectLimit(Pagenation param);
	public List<FullStudentInfo> search(Student param);
	public int 					 count(Student param);
}
