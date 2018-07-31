package com.runsystem.datnt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

	@Override
	public void initialize(PasswordConstraint arg0) {}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext arg1) {
		String regex = "^[a-zA-Z0-9~!@#$%^&*]{1,25}$";
		return input.matches(regex);
	}

}
