package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IStudentRecordsMapper;
import com.runsystem.datnt.dto.StudentRecords;

public class StudentRecordsService implements IStudentRecordsService {

	IStudentRecordsMapper studentRecordsMapper;
	
	@Override
	public int insert(StudentRecords studentInfo) {
		return studentRecordsMapper.insert(studentInfo);
	}

	@Override
	public int update(StudentRecords studentInfo) {
		return studentRecordsMapper.update(studentInfo);
	}

	@Override
	public int delete(int studentInfo) {
		return studentRecordsMapper.delete(studentInfo);
	}

	@Override
	public StudentRecords selectOne(StudentRecords studentInfo) {
		return studentRecordsMapper.selectOne(studentInfo);
	}

	@Override
	public List<StudentRecords> selectAll() {
		return studentRecordsMapper.selectAll();
	}

	public IStudentRecordsMapper getStudentRecordsMapper() {
		return studentRecordsMapper;
	}

	public void setStudentRecordsMapper(IStudentRecordsMapper studentRecordsMapper) {
		this.studentRecordsMapper = studentRecordsMapper;
	}
	
}
