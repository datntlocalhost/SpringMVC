package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.dto.Student;

public interface IStudentService {
	
	public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(int student);
	
	public Student getMaxID();
	
	public Student selectOne(Student student);
	
	public List<Student> selectAll();
}
