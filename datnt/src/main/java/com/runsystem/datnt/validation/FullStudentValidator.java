package com.runsystem.datnt.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.runsystem.datnt.dto.FullStudentInfo;

public class FullStudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		String codeRegex = "^[a-zA-Z0-9]{1,20}$";
		String nameRegex = "^[a-zA-Z0-9 ]{1,100}$";
		String addresRegex = "^[a-zA-Z0-9, ]{1,100}$";
		String dateRegex   = "^[0-9-,]{1,20}$";
		
		FullStudentInfo fullInfo = (FullStudentInfo) target;
		
		if (!fullInfo.getStudentName().matches(nameRegex)) {
			errors.rejectValue("studentName", "create.invalid.name");
		}
		
		if (!fullInfo.getStudentCode().matches(codeRegex)) {
			errors.rejectValue("studentCode", "create.invalid.code");
		}
		
		if (!fullInfo.getAddress().matches(addresRegex)) {
			errors.rejectValue("address", "create.invalid.address");
		}
		
		if (!fullInfo.getDateOfBirth().matches(dateRegex)) {
			errors.rejectValue("dateOfBirth", "create.invalid.date");
		}
	}

}
