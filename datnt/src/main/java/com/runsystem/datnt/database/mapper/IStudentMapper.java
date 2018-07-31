package com.runsystem.datnt.database.mapper;

import java.util.List;

import com.runsystem.datnt.dto.Student;

public interface IStudentMapper {
	
public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(Student student);
	
	public Student getMaxID();
	
	public Student selectOne(Student student);
	
	public List<Student> selectAll();

}
