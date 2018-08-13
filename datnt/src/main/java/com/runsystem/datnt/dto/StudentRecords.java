/**
 * StudentRecords class
 */
package com.runsystem.datnt.dto;

import java.io.Serializable;

public class StudentRecords implements Serializable {

	private static final long serialVersionUID = 1L;
	private int    studentId;
	private String address;
	private float averageScore;
	private String dateOfBirth;
	
	public StudentRecords() {}

	public StudentRecords(int studentId, String address, float avgScore, String dateOfBirth) {
		super();
		this.studentId = studentId;
		this.address = address;
		this.averageScore = avgScore;
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

	public float getAvgScore() {
		return averageScore;
	}

	public void setAvgScore(float avgScore) {
		this.averageScore = avgScore;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
