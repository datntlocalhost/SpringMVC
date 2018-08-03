/**
 * SearchStudent class
 * 
 * Chứa các phương thức tìm kiếm sinh viên 
 */

package com.runsystem.datnt.business;

import java.util.List;

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
	 * @param pageSearch 
	 * @param searchResult
	 * @param page 
	 * 
	 * @return PagenationResult
	 */
	public PagenationResult search(Pagenation pageSearch, StudentInfoService searchResult, int page) {
		Student          student = new Student(page, pageSearch.getStudentName(), pageSearch.getStudentCode());

		//Đếm số kết quả trả về 
		int numRow = searchResult.count(student);

		//Số page 
		int maxPage = numRow % 10 == 0 ? numRow/10 : numRow/10 + 1;

		if (maxPage == 0) {
			return null;
		}

		//Định vị trí bắt đầu tìm kiếm trong db
		pageSearch.setStartSearch(page == 1 ? 0 : (page - 1)*10);
		PagenationResult result  = new PagenationResult();

		//Truy vấn tìm kiếm và gán kết quả vào danh sách student.
		List<StudentInfo> students = searchResult.selectLimit(pageSearch);

		//Set danh sách student, vị trí page hiện tại và max page
		result.setStudents(students);
		result.setIndexPage(page);
		result.setMaxPage(maxPage);

		/* Set vị trí page bắt đầu và vị trí page kết thúc, nếu page < 5 thì 
		 * vị trí bắt đầu sẽ là 1 và vị trí kết thúc sẽ là 5 nếu maxPage > 5,
		 * ngược lại vị trí kết thúc sẽ là maxPage
		 * 
		 *        << [1 , 2 , |3| , 4 , 5] >>
		 */
		if (page < 5) {
			result.setStartPage(1);
			result.setEndPage(maxPage > 5 ? 5 : maxPage); 
		} else {
			if (page + 2 <= maxPage) {
				result.setEndPage(page + 2);
				result.setStartPage(result.getEndPage() - 4);
			}
		}

		return result;
	}

}
