/**
 * StudentInfo class
 * 
 * Định nghĩa đối tượng full info của sinh viên, 
 * Reference đến 2 table student và studentinfo 
 * trong db.
 */

package com.runsystem.datnt.dto;

import java.io.Serializable;

public class StudentInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int 	stutid;
	private int     infoId;
	private String  studentName;
	private String  studentCode;
	private String  address;
	private String  dateOfBirth;
	private float  averageScore;
	
	public StudentInfo() {}

	public StudentInfo(int studentId, int infoId, String studentName, String studentCode, String address, String dateOfBirth,
			float avgScore) {
		super();
		this.stutid   = studentId;
		this.infoId      = infoId;
		this.studentName = studentName;
		this.studentCode = studentCode;
		this.address     = address;
		this.dateOfBirth = dateOfBirth;
		this.averageScore    = avgScore;
	}

	public int getStudentId() {
		return stutid;
	}

	public void setStudentId(int studentid) {
		this.stutid = studentid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getAvgScore() {
		return averageScore;
	}

	public void setAvgScore(float avgScore) {
		this.averageScore = avgScore;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
}
