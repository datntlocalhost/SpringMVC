package com.runsystem.datnt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagenationResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int indexPage;
	private int numRaw;
	private int numHop;
	private List<FullStudentInfo> students = new ArrayList<>();
	
	public PagenationResult() {
		maxPage   = 1;
		indexPage = 1;
		numRaw    = 0;
		numHop    = 10;
	}

	public PagenationResult(int maxPage, int startPage, int endPage, int indexPage, int numRaw, int numHop,
			List<FullStudentInfo> students) {
		super();
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.indexPage = indexPage;
		this.numRaw = numRaw;
		this.numHop = numHop;
		this.students = students;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getNumRaw() {
		return numRaw;
	}

	public void setNumRaw(int numRaw) {
		this.numRaw = numRaw;
	}

	public int getNumHop() {
		return numHop;
	}

	public void setNumHop(int numHop) {
		this.numHop = numHop;
	}

	public List<FullStudentInfo> getStudents() {
		return students;
	}

	public void setStudents(List<FullStudentInfo> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
