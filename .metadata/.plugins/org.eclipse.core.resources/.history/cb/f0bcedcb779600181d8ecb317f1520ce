package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IStudentInfoMapper;
import com.runsystem.datnt.dto.StudentInfo;

public class StudentInfoService implements IStudentInfoService {

	IStudentInfoMapper studentInfoMapper;
	
	@Override
	public int insert(StudentInfo studentInfo) {
		return studentInfoMapper.insert(studentInfo);
	}

	@Override
	public int update(StudentInfo studentInfo) {
		return studentInfoMapper.update(studentInfo);
	}

	@Override
	public int delete(StudentInfo studentInfo) {
		return studentInfoMapper.delete(studentInfo);
	}

	@Override
	public StudentInfo selectOne(StudentInfo studentInfo) {
		return studentInfoMapper.selectOne(studentInfo);
	}

	@Override
	public List<StudentInfo> selectAll() {
		return studentInfoMapper.selectAll();
	}

	public IStudentInfoMapper getStudentInfoMapper() {
		return studentInfoMapper;
	}

	public void setStudentInfoMapper(IStudentInfoMapper studentInfoMapper) {
		this.studentInfoMapper = studentInfoMapper;
	}
}
