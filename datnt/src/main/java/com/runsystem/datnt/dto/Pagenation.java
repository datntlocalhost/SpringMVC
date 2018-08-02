package com.runsystem.datnt.dto;

import java.io.Serializable;

public class Pagenation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int start;  //vi tri bat dau lay du lieu tu database
	private int numHope;  //so luong ket qua duoc lay toi da
	private String studentName;
	private String studentCode;
	
	public Pagenation() {
		this.start   = 0;
		this.numHope = 10;
	}

	public Pagenation(int start, int numHope, String studentName, String studentCode) {
		super();
		this.start = start;
		this.numHope = numHope;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getNumHope() {
		return numHope;
	}

	public void setNumHope(int numHope) {
		this.numHope = numHope;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
