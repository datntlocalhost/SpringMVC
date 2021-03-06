package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IStudentInfoMapper;
import com.runsystem.datnt.dto.StudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.Student;

public class StudentInfoService implements IStudentInfoService {

	IStudentInfoMapper studentInfoMapper;
	
	public IStudentInfoMapper getFullStudentInfoMapper() {
		return studentInfoMapper;
	}

	public void setFullStudentInfoMapper(IStudentInfoMapper studentInfoMapper) {
		this.studentInfoMapper = studentInfoMapper;
	}

	public StudentInfo selectById(String id) {
		return studentInfoMapper.selectById(id);
	}

	public List<StudentInfo> selectLimit(Pagenation param) {
		return studentInfoMapper.selectLimit(param);
	}

	public List<StudentInfo> search(Student param) {
		return studentInfoMapper.search(param);
	}

	public List<StudentInfo> sortNameASC(Pagenation param) {
		return studentInfoMapper.sortNameASC(param);
	}

	public int count(Student param) {
		return studentInfoMapper.count(param);
	}

}
