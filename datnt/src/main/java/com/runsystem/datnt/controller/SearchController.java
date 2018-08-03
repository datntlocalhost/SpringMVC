/*
 * SearchController class 
 * 
 * Định nghĩa và chứa các phương thức giải quyết các GET và POST request
 * từ client liên quan đến chức năng tìm kiếm sinh viên và phân trang cho
 * bảng kết quả 
 * 
 * ver 1: sẽ optimize code lại cho class này 
 */
package com.runsystem.datnt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.runsystem.datnt.business.SearchStudent;
import com.runsystem.datnt.database.service.StudentInfoService;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.PagenationResult;
import com.runsystem.datnt.dto.Student;
import com.runsystem.datnt.validation.StudentValidator;

@Controller
public class SearchController {

	@Autowired
	StudentInfoService searchResult;

	/*
	 * Nhận thông tin tìm kiếm student name và student code từ client, tìm kiếm trong
	 * db và trả kết quả tìm kiếm cho client, lưu thông tin tìm kiếm vào trong session
	 * để phục vụ cho chức năng phân trang.
	 * 
	 * @param student 
	 * @param request 
	 * @param bindingResult 
	 * 
	 * @return PageationResult 
	 */
	@PostMapping(value="/admin/search", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody PagenationResult getResult(@ModelAttribute Student student, HttpServletRequest request, 
			BindingResult bindingResult) {
		
		//Check validation input 
		StudentValidator validator = new StudentValidator();
		validator.validate(student, bindingResult);
		if (bindingResult.hasErrors()) {
			return null;
		}
		SearchStudent search  = new SearchStudent();
		Pagenation pagenation = new Pagenation();	
		HttpSession session   = request.getSession();

		//set studentCode và studentName cho pagenation
		pagenation.setStudentCode(student.getStudentCode().length() > 0 ? student.getStudentCode(): null);
		pagenation.setStudentName(student.getStudentName().length() > 0 ? student.getStudentName(): null);
		
		PagenationResult result = search.search(pagenation, searchResult, 1);

		if (result != null) {

			pagenation.setCurPage(result.getIndexPage());
			pagenation.setStartPage(result.getStartPage());
			pagenation.setEndPage(result.getEndPage());

			session.setAttribute("pageinfo", pagenation);
		}
		return result;
	}

	/*
	 * Xử lý chuyển trang, nhận thông tin page từ client, search lại kết quả theo trang,
	 * định lại vị trí trang bắt đầu, kết thúc, vị trí trang hiện tại và trả kết quả 
	 * cho client.
	 * 
	 *  @param page
	 *  @param request
	 *  
	 *  @return PagenationResult 
	 */
	@RequestMapping(value = "/admin/search", method = RequestMethod.GET)
	public @ResponseBody PagenationResult changePage(@RequestParam("page") int page, HttpServletRequest request) {		
		HttpSession session = request.getSession();
		Pagenation pagenation = (Pagenation) session.getAttribute("pageinfo");
		if (pagenation == null) {
			return null;
		}

		SearchStudent search    = new SearchStudent();
		PagenationResult result = search.search(pagenation, searchResult, page);

		pagenation.setCurPage(result.getIndexPage());
		pagenation.setStartPage(result.getStartPage());
		pagenation.setEndPage(result.getEndPage());

		session.setAttribute("pageinfo", pagenation);

		return result;
	}

	/*
	 * Xử lý các request khi click nút tiến tới (Next) hoặc lùi lại (Prev) của page, 
	 * trả kết quả render cho client.
	 * 
	 * @param type 1 (Next) và -1 (Prev)
	 * @param request 
	 *  
	 * @return PagenationResult 
	 */
	@RequestMapping(value = "/admin/search/direct", method = RequestMethod.GET)
	public @ResponseBody PagenationResult directPage(@RequestParam("type") int type, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Pagenation pagenation = (Pagenation) session.getAttribute("pageinfo");
		if (pagenation == null) {
			return null;
		}

		int page = pagenation.getCurPage() + type;

		SearchStudent search    = new SearchStudent();
		PagenationResult result = search.search(pagenation, searchResult, page);

		pagenation.setCurPage(result.getIndexPage());
		pagenation.setStartPage(result.getStartPage());
		pagenation.setEndPage(result.getEndPage());

		session.setAttribute("pageinfo", pagenation);

		return result;
	}
}
