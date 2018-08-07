/**
 * SearchStudent class
 * 
 * Chứa các phương thức tìm kiếm sinh viên 
 */

package com.runsystem.datnt.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.dto.StudentInfo;

public class SearchStudent {


	/*
	 * Search kết quả dựa vào số page, định vị trí cho page bắt đầu, page kết thúc, set kết quả tìm kiếm
	 * vào đối tượng PagenationResult.
	 * 
	 * @param page 
	 * @param student
	 * @param infoService 
	 * 
	 * @return PagenationResult
	 */
	public PagenationResult search(int page, Student student, StudentInfoService infoService) {
		Pagenation pagenation = new Pagenation();
		List<StudentInfo> students = new ArrayList<StudentInfo>();
		
		//Số lượng row
		int numRow = infoService.count(student);
		
		//Số page 
		int numPage = numRow % 10 == 0 ? numRow/10 : numRow/10 + 1;
		
		//Tính toán giá tri cho startPage và endPage
		int startPage = 0;
		int endPage   = 0;
		
		if (page < 5) {
			startPage = 1;
			endPage   = (numPage < 5) ? numPage : 5; 
		} else {
			endPage   = (page + 2 < numPage) ? page + 2 : numPage;
			startPage = endPage - 6;
		}
		
		int curPage     = 1;
		
		if (page > 0 && page < numPage) {
			curPage = page;
		}
		if (page >= numPage) {
			curPage = numPage;
		}
		
		//Gán vị trí bắt đầu search 
		int startSearch = (curPage == 0) ? 0 : (curPage - 1)*10;
		
		pagenation.setCurPage(curPage);
		pagenation.setMaxPage(numPage);
		pagenation.setStartSearch(startSearch);
		pagenation.setStartPage(startPage);
		pagenation.setEndPage(endPage);
		pagenation.setStudentCode(student.getStudentCode());
		pagenation.setStudentName(student.getStudentName());
		
		//Search tối đa 10 sinh viên và gán kết quả vào students 
		students = infoService.selectLimit(pagenation);
		
		return new PagenationResult(pagenation, students);
	}

}
