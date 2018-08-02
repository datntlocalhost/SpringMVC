package com.runsystem.datnt.business;

import java.util.List;

import com.runsystem.datnt.database.service.FullStudentInfoService;
import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;

public class SearchStudent {
	/*
	public PagenationResult search(Student student, FullStudentInfoService searchResult, int page) {
		Pagenation pageSearch   = new Pagenation();
		PagenationResult result = new PagenationResult();
		
		pageSearch.setStudentCode(student.getStudentCode().length() > 0 ? student.getStudentCode(): null);
		pageSearch.setStudentName(student.getStudentName().length() > 0 ? student.getStudentName(): null);
		
		List<FullStudentInfo> students = searchResult.selectLimit(pageSearch);
		//lay so dong ket qua tim kiem
		int numRow = searchResult.count(student);
		
		result.setNumRaw(numRow);
		result.setStudents(students);
		/*
		 * số page sẽ là numRaw/10 nếu phần dư của numRow/10 < 0, 
		 * sẽ là numRow/10 + 1 nếu phần dư numRow/10 > 0
		 *//*
		int maxPage = numRow%10 > 0 ? numRow/10 + 1 : numRow/10;
		result.setMaxPage(maxPage);
		result.setStartPage(1);
		result.setEndPage(maxPage < 10 ? maxPage : 10);
		
		return result;
	}*/

}
