package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IStudentMapper;
import com.runsystem.datnt.dto.Student;

public class StudentService implements IStudentService {
	
	IStudentMapper studentMapper;

	public int insert(Student student) {
		return studentMapper.insert(student);
	}

	public int update(Student student) {
		return studentMapper.update(student);
	}

	public int delete(int student) {
		return studentMapper.delete(student);
	}

	public Student getMaxID() {
		return studentMapper.getMaxID();
	}

	public Student selectOne(Student student) {
		return studentMapper.selectOne(student);
	}

	public List<Student> selectAll() {
		return studentMapper.selectAll();
	}

	public IStudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(IStudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
}
