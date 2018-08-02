package com.runsystem.datnt.dto;

import java.io.Serializable;

public class FullStudentInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int 	studentId;
	private int     infoId;
	private String  studentName;
	private String  studentCode;
	private String  address;
	private String  dateOfBirth;
	private double  avgScore;
	
	public FullStudentInfo() {}

	public FullStudentInfo(int studentId, int infoId, String studentName, String studentCode, String address, String dateOfBirth,
			double avgScore) {
		super();
		this.studentId   = studentId;
		this.infoId      = infoId;
		this.studentName = studentName;
		this.studentCode = studentCode;
		this.address     = address;
		this.dateOfBirth = dateOfBirth;
		this.avgScore    = avgScore;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentid) {
		this.studentId = studentid;
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

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
}
