/**
 * Pagenation class
 * 
 * Define pagenation object that is used to save page info in session.
 */

package com.runsystem.datnt.dto;

import java.io.Serializable;

public class Pagenation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int startSearch;     //start positions to search in database
	private int maxPage;         //number of row in a page
	private int startPage;       //start page
	private int endPage;         //end page 
	private int curPage;         //current page 
	private String studentName;  
	private String studentCode;   

	public Pagenation() {
		this.startSearch = 0;
		this.curPage     = 0;
		this.startPage   = 0;
		this.endPage     = 0;
		this.maxPage     = 0;
	}

	public Pagenation(int startSearch, int numHope, int startPage, int endPage, int curPage, String studentName,
			String studentCode) {
		super();
		this.startSearch = startSearch;
		this.maxPage = numHope;
		this.startPage = startPage;
		this.endPage = endPage;
		this.curPage = curPage;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}

	public int getStartSearch() {
		return startSearch;
	}

	public void setStartSearch(int startSearch) {
		this.startSearch = startSearch;
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

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
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
