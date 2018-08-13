/**
 * SearchStudent class
 */

package com.runsystem.datnt.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;

public class SearchStudent {


	/*
	 * Search student depend on student info get from client. After that, set position of start page,
	 * end page and return search result.
	 * 
	 * @param page 
	 * @param student
	 * @param infoService 
	 * 
	 * @return PagenationResult
	 */
	public PagenationResult search(int page, Student student, StudentInfoService infoService) {
		//pagenation contain page info, and save it in session
		Pagenation pagenation = new Pagenation();
		
		//pageResult contain page info and list of student to send to client 
		PagenationResult pageResult = new PagenationResult();
		
		//students is student list contain studentinfo
		List<StudentInfo> students = new ArrayList<StudentInfo>();
		
		//number of row search
		int numRow = infoService.count(student);
		
		//number of page for that entry, default one page can display 10 entry 
		int numPage = numRow % 10 == 0 ? numRow/10 : numRow/10 + 1;
		
		//if numpage requiment larger than number of page 
		if (page > numPage) {
			page = numPage;
		}
		
		//init startPage and endPage equals zero
		int startPage = 0;
		int endPage   = 0;
		
		//if num page is smaller than 5
		if (page < 5) {
			startPage = 1;
			endPage   = (numPage < 5) ? numPage : 5; 
		} else {
			endPage   = (page + 2 < numPage) ? page + 2 : numPage;
			startPage = endPage - 6;
		}
		
		//set current page
		int curPage = 1;
		
		if (page > 0 && page < numPage) {
			curPage = page;
		}
		if (page >= numPage) {
			curPage = numPage;
		}
		
		//set start positions to search 
		int startSearch = (curPage == 0) ? 0 : (curPage - 1)*10;
		
		pagenation.setCurPage(curPage);
		pagenation.setMaxPage(numPage);
		pagenation.setStartSearch(startSearch);
		pagenation.setStartPage(startPage);
		pagenation.setEndPage(endPage);
		pagenation.setStudentCode(student.getStudentCode());
		pagenation.setStudentName(student.getStudentName());
		
		//Search limit 10 student and asignment result to student list
		students = infoService.selectLimit(pagenation);
		
		//put pagenation info and student list into pageResult 
		pageResult.setPagenation(pagenation);
		pageResult.setStudents(students);
		
		return pageResult;
	}

}
