package com.runsystem.datnt.dto;

import java.io.Serializable;

public class StudentInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int    studentId;
	private String address;
	private double avgScore;
	private String dateOfBirth;
	
	public StudentInfo() {}

	public StudentInfo(int studentId, String address, double avgScore, String dateOfBirth) {
		super();
		this.studentId = studentId;
		this.address = address;
		this.avgScore = avgScore;
		this.dateOfBirth = dateOfBirth;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
