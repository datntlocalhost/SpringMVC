/**
 * PagenationResult class
 * 
 * Defines pagenation result object, which is used to send search result and page info to
 * client.
 * 
 * Pagenation result contain list of student object, pagenation object. 
 */

package com.runsystem.datnt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagenationResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pagenation        pagenation;
	private List<StudentInfo> students;
	
	public PagenationResult() {
		this.pagenation = new Pagenation();
		this.students   = new ArrayList<StudentInfo>();
	}

	public PagenationResult(Pagenation pagenation, List<StudentInfo> students) {
		super();
		this.pagenation = pagenation;
		this.students = students;
	}

	public Pagenation getPagenation() {
		return pagenation;
	}

	public void setPagenation(Pagenation pagenation) {
		this.pagenation = pagenation;
	}

	public List<StudentInfo> getStudents() {
		return students;
	}

	public void setStudents(List<StudentInfo> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
