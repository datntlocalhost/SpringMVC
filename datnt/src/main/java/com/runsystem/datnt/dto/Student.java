/**
 * Student class
 */

package com.runsystem.datnt.dto;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int    studentID;
	private String studentName;
	private String studentCode;
	
	public Student() {}

	public Student(int studentID, String studentName, String studentCode) {
		super();
		this.studentID   = studentID;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
}
