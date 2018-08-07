/**
 * StudentInfoValidator class
 * 
 * Chứa các phương thức được sử dụng cho việc kiểm tra tính hợp lệ của các 
 * trường dữ liệu của đối tượng StudentInfo
 */

package com.runsystem.datnt.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.runsystem.datnt.dto.StudentInfo;

public class StudentInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		String nameRegex = "^[a-zA-Z0-9 ]{5,100}$";
		String addresRegex = "^[a-zA-Z0-9, ]{0,100}$";
		String dateRegex   = "^[0-9-,]{5,20}$";
		
		StudentInfo fullInfo = (StudentInfo) target;
		
		if (!fullInfo.getStudentName().matches(nameRegex)) {
			errors.rejectValue("studentName", "create.invalid.name");
		}
		
		if (!fullInfo.getAddress().matches(addresRegex)) {
			errors.rejectValue("address", "create.invalid.address");
		}
		
		if (!fullInfo.getDateOfBirth().matches(dateRegex)) {
			errors.rejectValue("dateOfBirth", "create.invalid.date");
		}
	}

}
